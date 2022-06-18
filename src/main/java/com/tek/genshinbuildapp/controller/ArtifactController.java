package com.tek.genshinbuildapp.controller;

import com.tek.genshinbuildapp.service.ArtifactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArtifactController {

    private ArtifactService artifactService;

    @Autowired
    public ArtifactController(ArtifactService artifactService) {
        this.artifactService = artifactService;
    }

    @GetMapping("/artifacts")
    public String artifactHome(Model model) {
        return "artifacts";
    }

    @GetMapping("/artifacts-save")
    public String showForm() {
        return "artifacts-save";
    }
}
