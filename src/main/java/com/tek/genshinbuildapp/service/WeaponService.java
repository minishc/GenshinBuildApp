package com.tek.genshinbuildapp.service;

import com.tek.genshinbuildapp.dao.WeaponRepository;
import com.tek.genshinbuildapp.dao.WeaponSecondaryStatRepository;
import com.tek.genshinbuildapp.model.Weapon;
import com.tek.genshinbuildapp.model.WeaponSecondaryStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeaponService {

    private final WeaponSecondaryStatRepository secondaryStatRepository;
    private final WeaponRepository weaponRepository;

    @Autowired
    public WeaponService(WeaponRepository weaponRepository,
                         WeaponSecondaryStatRepository secondaryStatRepository) {
        this.secondaryStatRepository = secondaryStatRepository;
        this.weaponRepository = weaponRepository;
    }

    public void saveWeapon(Weapon weapon, WeaponSecondaryStat secondary) {
        WeaponSecondaryStat secondaryStat = secondaryStatRepository.save(secondary);
        weapon.setSecondaryStat(secondaryStat);
        weaponRepository.save(weapon);
    }
}
