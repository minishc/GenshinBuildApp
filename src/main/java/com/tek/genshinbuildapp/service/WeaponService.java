package com.tek.genshinbuildapp.service;

import com.tek.genshinbuildapp.dao.WeaponRepository;
import com.tek.genshinbuildapp.dao.WeaponSecondaryStatRepository;
import com.tek.genshinbuildapp.model.User;
import com.tek.genshinbuildapp.model.Weapon;
import com.tek.genshinbuildapp.model.WeaponSecondaryStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class WeaponService {

    private final WeaponSecondaryStatRepository secondaryStatRepository;
    private final WeaponRepository weaponRepository;
    private final UserService userService;

    @Autowired
    public WeaponService(WeaponRepository weaponRepository,
                         WeaponSecondaryStatRepository secondaryStatRepository,
                         UserService userService) {
        this.secondaryStatRepository = secondaryStatRepository;
        this.weaponRepository = weaponRepository;
        this.userService = userService;
    }

    public void saveWeapon(Weapon weapon, WeaponSecondaryStat secondary) {
        WeaponSecondaryStat secondaryStat = secondaryStatRepository.save(secondary);
        weapon.setSecondaryStat(secondaryStat);
        weaponRepository.save(weapon);
    }

    public void saveAll(List<Weapon> weapons) {
        weaponRepository.saveAll(weapons);
    }

    public List<Weapon> retrieveWeapons() {
        return weaponRepository.findAll();
    }

    public void removeWeapons(User user, Set<Weapon> weapons) {
        Set<Weapon> updated = user.getWeapons();
        weapons.forEach(updated::remove);
        user.setWeapons(updated);
        userService.saveUser(user);
    }
}
