package com.tek.genshinbuildapp.dao;

import com.tek.genshinbuildapp.model.ArtifactSubstat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtifactSubstatRepository extends JpaRepository<ArtifactSubstat, Integer> {
    Optional<ArtifactSubstat> findByStatNameAndStatValue(String statName, double statValue);
}
