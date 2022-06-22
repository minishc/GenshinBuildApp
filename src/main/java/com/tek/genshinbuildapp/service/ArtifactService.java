package com.tek.genshinbuildapp.service;

import com.tek.genshinbuildapp.dao.ArtifactMainstatRepository;
import com.tek.genshinbuildapp.dao.ArtifactRepository;
import com.tek.genshinbuildapp.dao.ArtifactSubstatRepository;
import com.tek.genshinbuildapp.dto.ArtifactDto;
import com.tek.genshinbuildapp.model.Artifact;
import com.tek.genshinbuildapp.model.ArtifactMainstat;
import com.tek.genshinbuildapp.model.ArtifactSubstat;
import com.tek.genshinbuildapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
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

    public List<Artifact> retrieveArtifacts(User user) {
        return artifactRepository.findAllByUserId(user.getId());
    }

    public void saveArtifact(long id, Artifact artifact, ArtifactMainstat mainstat, Set<ArtifactSubstat> substats) {
        substatRepository.saveAll(substats);
        mainstatRepository.save(mainstat);
        artifact.setMainstat(mainstat);
        artifact.setSubstats(substats);
        artifact.setUser(userService.retrieveUser(id));
        artifactRepository.save(artifact);
    }

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
}
