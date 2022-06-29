package com.tek.genshinbuildapp.controller;

import com.tek.genshinbuildapp.dto.UserDto;
import com.tek.genshinbuildapp.model.User;
import com.tek.genshinbuildapp.model.Weapon;
import com.tek.genshinbuildapp.service.UserService;
import com.tek.genshinbuildapp.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WeaponController {

    private WeaponService weaponService;
    private UserService userService;

    @Autowired
    public WeaponController(WeaponService weaponService,
                            UserService userService) {
        this.weaponService = weaponService;
        this.userService = userService;
    }

    @GetMapping("/weapons")
    public String displayWeapons(Model model) {
        User user = userService.retrieveUser(1);
        UserDto dto = new UserDto(user.getId());
        dto.setWeapons(user.getWeapons());
        model.addAttribute("user", dto);
        model.addAttribute("weaponList", weaponService.retrieveWeapons());
        return "weapons";
    }

    @PostMapping("/weapons/update/{id}")
    public String saveWeapons(@ModelAttribute("user") UserDto user,
                                @PathVariable("id") long id) {
        User original = userService.retrieveUser(id);
        user.getWeapons().forEach(original.getWeapons()::add);
        userService.saveUser(original);
        if(user.getRemoveWeapon() != null) {
            weaponService.removeWeapons(original, user.getRemoveWeapon());
        }
        return "redirect:/weapons";
    }
}
