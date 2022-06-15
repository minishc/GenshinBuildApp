package com.tek.genshinbuildapp.service;

import com.tek.genshinbuildapp.dao.WeaponSecondaryStatRepository;
import com.tek.genshinbuildapp.model.WeaponSecondaryStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeaponSecondaryStatService {

    private final WeaponSecondaryStatRepository secondaryStatRepository;

    @Autowired
    public WeaponSecondaryStatService(WeaponSecondaryStatRepository secondaryStatRepository) {
        this.secondaryStatRepository = secondaryStatRepository;
    }

    public void saveStat(WeaponSecondaryStat secondaryStat) {
        secondaryStatRepository.save(secondaryStat);
    }

    public void saveAllStats(List<WeaponSecondaryStat> stats) {
        secondaryStatRepository.saveAll(stats);
    }

    public WeaponSecondaryStat findByData(String statName, double statValue) {
        return secondaryStatRepository.findByStatNameAndStatValue(statName, statValue);
    }
}
