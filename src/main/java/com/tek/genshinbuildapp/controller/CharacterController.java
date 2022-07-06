package com.tek.genshinbuildapp.controller;

import com.tek.genshinbuildapp.dto.UserDto;
import com.tek.genshinbuildapp.model.User;
import com.tek.genshinbuildapp.service.CharacterService;
import com.tek.genshinbuildapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityNotFoundException;
import java.security.Principal;

@Controller
@Slf4j
public class CharacterController {

    private CharacterService characterService;
    private UserService userService;

    @Autowired
    public CharacterController(CharacterService characterService,
                               UserService userService) {
        this.characterService = characterService;
        this.userService = userService;
    }

    @GetMapping("/characters")
    public String showCharacters(Model model, Principal principal) {
        User user = new User();
        UserDto dto = new UserDto();
        if(principal != null) {
            user = userService.retrieveUser(principal.getName());
            dto = new UserDto(user.getId());
        }
        dto.setCharacters(user.getCharacters());
        model.addAttribute("user", dto);
        model.addAttribute("characterList", characterService.retrieveCharacters());
        return "characters";
    }

    @PostMapping("/characters/update/{id}")
    public String updateCharacterList(@ModelAttribute("UserDto") UserDto user,
                                       @PathVariable("id") long id) {
        User original = userService.retrieveUser(id);
        user.getCharacters().forEach(original.getCharacters()::add);
        userService.saveUser(original);
        if(user.getRemoveCharacter() != null) {
            userService.removeAllCharacters(original, user.getRemoveCharacter());
            log.info(user.getRemoveCharacter().toString());
        }
        return "redirect:/characters";
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
