package com.tek.genshinbuildapp.dao;

import com.tek.genshinbuildapp.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {

    Optional<Character> findCharacterByName(String name);
}
