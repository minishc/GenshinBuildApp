package com.tek.genshinbuildapp.service;

import com.tek.genshinbuildapp.dao.WeaponRepository;
import com.tek.genshinbuildapp.dao.WeaponSecondaryStatRepository;
import com.tek.genshinbuildapp.model.Weapon;
import com.tek.genshinbuildapp.model.WeaponSecondaryStat;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class WeaponServiceTest {

    @Mock
    static WeaponRepository weaponRepository;

    @Mock
    static WeaponSecondaryStatRepository secondaryRepository;

    @InjectMocks
    static WeaponService weaponService;

    static WeaponSecondaryStat secondaryStat;

    static Weapon weapon;

    @BeforeAll
    static void setup() {
        secondaryStat = new WeaponSecondaryStat("ATK%", 44.1);
        weapon = new Weapon("A sword", "Sword", 627, "addToBuild.png",
                secondaryStat);
        weapon.setId(1);
    }

    @Test
    void retrieveWeapons() {
        List<Weapon> weaponList = List.of(weapon);
        when(weaponRepository.findAll()).thenReturn(weaponList);
        Assertions.assertThat(weaponService.retrieveWeapons()).isNotNull()
                .hasSize(1).containsOnly(weapon);
        verify(weaponRepository).findAll();
    }

    @Test
    void removeWeapons() {
    }
}