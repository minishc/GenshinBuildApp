package com.tek.genshinbuildapp.service;

import com.tek.genshinbuildapp.dao.ArtifactMainstatRepository;
import com.tek.genshinbuildapp.dao.ArtifactRepository;
import com.tek.genshinbuildapp.dao.ArtifactSubstatRepository;
import com.tek.genshinbuildapp.model.Artifact;
import com.tek.genshinbuildapp.model.ArtifactMainstat;
import com.tek.genshinbuildapp.model.ArtifactSubstat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class ArtifactServiceTests {

    @Mock
    ArtifactRepository artifactRepository;
    @Mock
    ArtifactSubstatRepository artifactSubstatRepository;
    @Mock
    ArtifactMainstatRepository artifactMainstatRepository;
    @Mock
    UserService userService;
    @InjectMocks
    ArtifactService artifactService;

    static ArtifactMainstat mainstat;
    static ArtifactSubstat substat;
    static ArtifactSubstat substat2;
    static ArtifactSubstat substat3;
    static ArtifactSubstat substat4;
    static Set<ArtifactSubstat> substats;
    static Artifact artifact;

    @BeforeAll
    static void setup() {
        mainstat = new ArtifactMainstat("ATK", 311);
        substat = new ArtifactSubstat("DEF", 17);
        substat2 = new ArtifactSubstat("CRIT Rate", 5.4);
        substat3 = new ArtifactSubstat("CRIT Damage", 7.8);
        substat4 = new ArtifactSubstat("DEF%", 12.4);
        substats = new LinkedHashSet<>();
        substats.add(substat);
        substats.add(substat2);
        substats.add(substat3);
        substats.add(substat4);
        artifact = new Artifact("Emblem of the Severed Fates", "flower");
        artifact.setMainstat(mainstat);
        artifact.setSubstats(substats);
    }

    @Test
    @Order(1)
    void retrieveArtifacts() {

    }

    @Test
    @Order(2)
    void deleteArtifact() {
        artifactService.saveArtifact(1, artifact, mainstat, substats);
        verify(artifactSubstatRepository).saveAll(substats);
        verify(artifactMainstatRepository).save(mainstat);
        verify(artifactRepository).save(artifact);
    }
}