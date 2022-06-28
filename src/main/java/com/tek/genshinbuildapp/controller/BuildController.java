package com.tek.genshinbuildapp.controller;

import com.tek.genshinbuildapp.model.Build;
import com.tek.genshinbuildapp.model.User;
import com.tek.genshinbuildapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityNotFoundException;

@Controller
@RequestMapping("/builds")
public class BuildController {

    private final UserService userService;
    private final ArtifactService artifactService;


    @Autowired
    public BuildController(UserService userService,
                           ArtifactService artifactService) {
        this.userService = userService;
        this.artifactService = artifactService;
    }

    @GetMapping("")
    public String buildOwned(Model model) {
        //TODO: when implementing spring security this should use the principal
        Build build = new Build();
        model.addAttribute("build", build);
        try {
            User user = userService.retrieveUser(1);
            model.addAttribute("user", user);
            model.addAttribute("characters", user.getCharacters());
            model.addAttribute("weapons", user.getWeapons());
            model.addAttribute("artifacts", artifactService.retrieveArtifacts(user));
        }
        catch (EntityNotFoundException exc) {
            model.addAttribute("message", "There was an error retrieving user, characters, weapons" +
                    ", or artifacts for user: " + userService.retrieveUser(1).getUsername());
        }
        return "build";
    }

    @GetMapping("/{id}")
    public String builds(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.retrieveUser(id));
        return "my-builds";
    }
}
