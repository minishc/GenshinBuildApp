package com.tek.genshinbuildapp.controller;

import com.tek.genshinbuildapp.model.Weapon;
import com.tek.genshinbuildapp.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

//    @PostMapping("/{username}/weapons")
//    public String saveWeaponsToUser(@PathVariable("username") String username, Model model) {
//        try {
//            List<Weapon> weapons = (List<Weapon>) model.getAttribute("weapons");
//        }
//        catch(Exception exc) {
//            return "redirect:/error";
//        }
//        return "redirect:/user-page";
//    }
}
