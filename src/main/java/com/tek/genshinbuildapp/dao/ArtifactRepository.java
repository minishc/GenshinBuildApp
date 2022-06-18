package com.tek.genshinbuildapp.dao;

import com.tek.genshinbuildapp.model.Artifact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtifactRepository extends JpaRepository<Artifact, Long> {
    List<Artifact> findAllByUserId(long userId);
}
