package com.tek.genshinbuildapp.controller;

import com.tek.genshinbuildapp.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeaponController {

    private WeaponService weaponService;

    @Autowired
    public WeaponController(WeaponService weaponService) {
        this.weaponService = weaponService;
    }

    @GetMapping("/weapons")
    public String displayWeapons(Model model) {
        model.addAttribute("weapons", weaponService.retrieveWeapons());
        return "weapons";
    }
}
