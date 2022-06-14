package com.tek.genshinbuildapp.dao;

import com.tek.genshinbuildapp.model.WeaponSecondaryStat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeaponSecondaryStatRepository extends JpaRepository<WeaponSecondaryStat, Integer> {
    WeaponSecondaryStat findByStatNameAndStatValue(String statName, double statValue);
}
