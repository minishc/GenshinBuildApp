package com.tek.genshinbuildapp.service;

import com.tek.genshinbuildapp.dao.ArtifactMainstatRepository;
import com.tek.genshinbuildapp.dao.ArtifactRepository;
import com.tek.genshinbuildapp.dao.ArtifactSubstatRepository;
import com.tek.genshinbuildapp.dto.ArtifactDto;
import com.tek.genshinbuildapp.model.Artifact;
import com.tek.genshinbuildapp.model.ArtifactMainstat;
import com.tek.genshinbuildapp.model.ArtifactSubstat;
import com.tek.genshinbuildapp.model.User;
import com.tek.genshinbuildapp.utility.ArtifactUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ArtifactService {

    private ArtifactRepository artifactRepository;
    private ArtifactMainstatRepository mainstatRepository;
    private ArtifactSubstatRepository substatRepository;
    private UserService userService;

    @Autowired
    public ArtifactService(ArtifactRepository artifactRepository,
                           ArtifactMainstatRepository mainstatRepository,
                           ArtifactSubstatRepository substatRepository,
                           UserService userService) {
        this.artifactRepository = artifactRepository;
        this.mainstatRepository = mainstatRepository;
        this.substatRepository = substatRepository;
        this.userService = userService;
    }

    //simple Query method call
    public List<Artifact> retrieveArtifacts(User user) {
        return artifactRepository.findAllByUserId(user.getId());
    }

    /*
        Adjusts the slot name to be as it appears on the artifacts in game.
        Then saves any new substats and mainstats, then the artifact itself
     */
    public void saveArtifact(long id, Artifact artifact, ArtifactMainstat mainstat, Set<ArtifactSubstat> substats) {
        ArtifactSubstat[] substatArray = new ArtifactSubstat[4];
        switch(artifact.getSlot().toLowerCase()) {
            case "flower": {
                artifact.setSlot("Flower of Life");
            } break;
            case "plume": {
                artifact.setSlot("Plume of Death");
            } break;
            case "sands": {
                artifact.setSlot("Sands of Eon");
            } break;
            case "goblet": {
                artifact.setSlot("Goblet of Eonothem");
            } break;
            case "circlet": {
                artifact.setSlot("Circlet of Logos");
            } break;
        }
        ArtifactUtility.validateSubstats(substats.toArray(substatArray));
        Set<ArtifactSubstat> fixedSubstats = new LinkedHashSet<>();
        /*
            Since ArtifactSubstats have a unique constraint check the database for substats
            that have the statName/statValue combination and put those into a new set
            for saving with the artifact
         */
        substats.forEach(substat -> {
            Optional<ArtifactSubstat> result = substatRepository.findByStatNameAndStatValue(substat.getStatName(), substat.getStatValue());
            if(result.isEmpty()) {
                fixedSubstats.add(substat);
                substatRepository.save(substat);
            } else {
                fixedSubstats.add(result.get());
            }
        });
        Optional<ArtifactMainstat> result = mainstatRepository.findByStatNameAndStatValue(mainstat.getStatName(), mainstat.getStatValue());
        /*
            ArtifactMainstats also have a unique constraint so we first check if there is an existing entry
            with the statName/statValue pair we need
         */
        if(result.isEmpty()) {
            mainstatRepository.save(mainstat);
            artifact.setMainstat(mainstat);
        }
        else {
            artifact.setMainstat(result.get());
        }
        //after setting relationships, save the artifact
        artifact.setSubstats(fixedSubstats);
        artifact.setUser(userService.retrieveUser(id));
        artifactRepository.save(artifact);
    }

    /*
        This is a service method that is used when parsing an uploaded csv file,
        it separates artifacts and converts data types and then calls the above
        method for doing the saving
     */
    public void saveFromDtoList(List<ArtifactDto> dtos) {
        for(ArtifactDto dto : dtos) {
            Set<ArtifactSubstat> substats = new LinkedHashSet<>();
            Artifact artifact = new Artifact(dto.getSet(), dto.getSlot());
            ArtifactMainstat mainstat = new ArtifactMainstat(dto.getStatNames()[0], dto.getStatValues()[0]);
            for(int i = 1; i < 5; i++) {
                substats.add(new ArtifactSubstat(dto.getStatNames()[i], dto.getStatValues()[i]));
            }
            saveArtifact(dto.getUserId(), artifact, mainstat, substats);
        }
    }

    //Simply deletes an artifact
    public void deleteArtifact(long id) {
        artifactRepository.deleteById(id);
    }
}
