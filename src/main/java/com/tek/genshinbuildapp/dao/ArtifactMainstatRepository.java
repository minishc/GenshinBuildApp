package com.tek.genshinbuildapp.dao;

import com.tek.genshinbuildapp.model.ArtifactMainstat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtifactMainstatRepository extends JpaRepository<ArtifactMainstat, Integer> {
}
