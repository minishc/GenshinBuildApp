package com.tek.genshinbuildapp.dao;

import com.tek.genshinbuildapp.model.Build;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildRepository extends JpaRepository<Build, Integer> {
}
