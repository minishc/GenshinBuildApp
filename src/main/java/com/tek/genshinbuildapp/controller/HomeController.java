package com.tek.genshinbuildapp.controller;

import com.tek.genshinbuildapp.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private CharacterService characterService;

    @Autowired
    public HomeController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/")
    public String homePage(Model model) {

        return "index";
    }
}
