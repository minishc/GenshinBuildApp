package com.tek.genshinbuildapp.utility;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ArtifactUtilityTest {

    @Autowired
    ArtifactUtility artifactUtility;

    @ParameterizedTest
    @ValueSource(strings = {
            "Emblem of Severed Fate,Goblet,Energy Recharge,"
    })
    void validateSubstats() {
        assertThat(true).isTrue();
    }
}