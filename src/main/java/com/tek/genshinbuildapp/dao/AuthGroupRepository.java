package com.tek.genshinbuildapp.dao;


import com.tek.genshinbuildapp.model.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthGroupRepository extends JpaRepository<AuthGroup, Long> {

    List<AuthGroup> findAllByUsername(String username);
}
