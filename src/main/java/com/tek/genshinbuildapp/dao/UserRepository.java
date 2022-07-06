package com.tek.genshinbuildapp.dao;

import com.tek.genshinbuildapp.model.Character;
import com.tek.genshinbuildapp.model.User;
import com.tek.genshinbuildapp.model.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<Weapon> findAllWeaponsById(long id);
    List<Character> findAllCharactersById(long id);
    Optional<User> findByUsername(String username);
}
