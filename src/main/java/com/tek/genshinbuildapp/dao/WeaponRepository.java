package com.tek.genshinbuildapp.dao;

import com.tek.genshinbuildapp.model.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponRepository extends JpaRepository<Weapon, Integer> {

}
