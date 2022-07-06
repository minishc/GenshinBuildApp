package com.tek.genshinbuildapp.dao;

import com.tek.genshinbuildapp.model.ArtifactMainstat;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
class ArtifactMainstatRepositoryTest {
    @Autowired ArtifactMainstatRepository repository;

    static ArtifactMainstat mainstat;

    @BeforeEach
    void setup() {
        mainstat = new ArtifactMainstat("ATK", 17);
        repository.save(mainstat);
        mainstat.setId(1);
    }

    @AfterEach
    void teardown() {
        repository.delete(mainstat);
    }

    @Test
    void findByStatNameAndStatValue() {
        Optional<ArtifactMainstat> expected = Optional.of(new ArtifactMainstat(1, "ATK", 17));
        Assertions.assertThat(repository.findByStatNameAndStatValue("ATK", 17)).isNotNull()
                .isPresent().contains(mainstat);
    }
}