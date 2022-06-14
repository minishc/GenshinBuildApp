package com.tek.genshinbuildapp.dao;

import com.tek.genshinbuildapp.model.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, Integer> {
}
