package com.tek.genshinbuildapp.service;

import com.tek.genshinbuildapp.dao.ArtifactMainstatRepository;
import com.tek.genshinbuildapp.dao.ArtifactRepository;
import com.tek.genshinbuildapp.dao.ArtifactSubstatRepository;
import com.tek.genshinbuildapp.model.Artifact;
import com.tek.genshinbuildapp.model.ArtifactMainstat;
import com.tek.genshinbuildapp.model.ArtifactSubstat;
import com.tek.genshinbuildapp.model.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
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
    static User user;

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
        user = new User(1, "Chris", "Password");
        artifact = new Artifact("Emblem of the Severed Fates", "flower");
        artifact.setUser(user);
        artifact.setMainstat(mainstat);
        artifact.setSubstats(substats);
    }

    @Test
    @Order(1)
    void retrieveArtifacts() {
        when(artifactRepository.findAllByUserId(artifact.getUser().getId())).thenReturn(List.of(artifact));
        Assertions.assertThat(artifactService.retrieveArtifacts(artifact.getUser()))
                .isNotNull().hasSize(1).containsOnly(artifact);
        verify(artifactRepository).findAllByUserId(artifact.getUser().getId());
    }

    @Test
    @Order(2)
    void saveArtifact() {
        artifactService.saveArtifact(1, artifact, mainstat, substats);
        substats.forEach(substat -> verify(artifactSubstatRepository).save(substat));
        verify(artifactMainstatRepository).save(mainstat);
        verify(artifactRepository).save(artifact);
    }
}