package com.tek.genshinbuildapp.controller;

import com.tek.genshinbuildapp.dto.BuildDto;
import com.tek.genshinbuildapp.model.Artifact;
import com.tek.genshinbuildapp.model.Build;
import com.tek.genshinbuildapp.model.User;
import com.tek.genshinbuildapp.service.BuildService;
import com.tek.genshinbuildapp.service.CharacterService;
import com.tek.genshinbuildapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.security.Principal;
import java.util.LinkedHashSet;
import java.util.Set;

@Controller
@Slf4j
@RequestMapping("/builds")
public class BuildController {

    private final UserService userService;
    private final BuildService buildService;
    private final CharacterService characterService;

    @Autowired
    public BuildController(UserService userService,
                           BuildService buildService,
                           CharacterService characterService) {
        this.userService = userService;
        this.buildService = buildService;
        this.characterService = characterService;
    }

    @GetMapping("")
    public String buildOwned(Model model, Principal principal) {
        BuildDto build = new BuildDto();
        try {
            User user = userService.retrieveUser(userService.retrieveUser(principal.getName()).getId());
            model.addAttribute("build", build);
            model.addAttribute("characters", user.getCharacters());
            model.addAttribute("weapons", user.getWeapons());
            model.addAttribute("artifactList", user.getArtifacts());
        }
        catch (EntityNotFoundException exc) {
            model.addAttribute("message", "There was an error retrieving user, characters, weapons" +
                    ", or artifacts for user: " + userService.retrieveUser(principal.getName()).getUsername());
        }
        return "build";
    }

    @PostMapping("")
    public String saveBuild(Model model,
                            @ModelAttribute("build") BuildDto build,
                            BindingResult result,
                            Principal principal) {
        if(result.hasErrors()) {
            log.info(result.getAllErrors().toString());
        }
        Set<Artifact> artifacts = new LinkedHashSet<>();
        artifacts.add(build.getFlower());
        artifacts.add(build.getPlume());
        artifacts.add(build.getSands());
        artifacts.add(build.getGoblet());
        artifacts.add(build.getCirclet());
        Build buildToSave = new Build();
        buildToSave.setWeapon(build.getWeapon());
        buildToSave.setCharacter(build.getCharacter());
        User user = new User();
        try {
            user = userService.retrieveUser(principal.getName());
        }
        catch(Exception exc) {
            log.info("No user was logged in somehow");
        }
        buildToSave.setUser(user);
        buildToSave.setArtifacts(artifacts);
        buildService.saveBuild(buildToSave);
        return "redirect:/builds";
    }

    @GetMapping("user/{id}")
    public String builds(Model model, @PathVariable("id") long id) {
        //TODO: Build page with a user's builds
        return "my-builds";
    }

    @GetMapping("character/{characterName}")
    public String buildWith(@PathVariable("characterName") String name,
                            Model model,
                            Principal principal) {
        //TODO: send to a page to make a build with a specific character
        User user = new User();
        try {
            user = userService.retrieveUser(principal.getName());
        }
        catch(Exception exc) {
            log.info("No user found with username: " + principal.getName());
        }
        String[] value = name.split("_");
        StringBuilder adjustedName = new StringBuilder();
        for(int i = 0; i < value.length; i++) {
            if(i > 0) {
                adjustedName.append(" ");
            }
            adjustedName.append(value[i]);
        }
        BuildDto build = new BuildDto();
        build.setCharacter(characterService.findCharacterByName(adjustedName.toString()));
        model.addAttribute("build", build);
        model.addAttribute("characters", build.getCharacter());
        model.addAttribute("weapons", user.getWeapons());
        model.addAttribute("artifacts", user.getArtifacts());
        return "build";
    }
}
