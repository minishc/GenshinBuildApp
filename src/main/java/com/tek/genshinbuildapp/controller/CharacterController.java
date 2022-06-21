package com.tek.genshinbuildapp.controller;

import com.tek.genshinbuildapp.service.CharacterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;

@Controller
@Slf4j
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

    @GetMapping("/character/{name}")
    public String characterPage(@PathVariable String name, Model model, RedirectAttributes redirectAttributes) {
        try {
            model.addAttribute("character", characterService.findCharacterByName(name));
        }
        catch (EntityNotFoundException exc) {
            redirectAttributes.addAttribute("message", exc.toString());
            log.info(exc.toString());
            return "redirect:/characters";
        }
        return "character-page";
    }
}
