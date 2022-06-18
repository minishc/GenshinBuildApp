package com.tek.genshinbuildapp.controller;

import com.tek.genshinbuildapp.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CharacterController {

    private CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/characters")
    public String showCharacters(Model model) {
        model.addAttribute("characters", characterService.retrieveCharacters());
        return "characters";
    }

    @GetMapping("/character?{id}")
    public String characterPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("character", characterService.findCharacterById(id));
        return "character-page";
    }
}
