package com.tek.genshinbuildapp.controller;

import com.tek.genshinbuildapp.model.Artifact;
import com.tek.genshinbuildapp.model.ArtifactMainstat;
import com.tek.genshinbuildapp.model.ArtifactSubstat;
import com.tek.genshinbuildapp.service.ArtifactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedHashSet;
import java.util.Set;

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

    @GetMapping("/artifacts/save")
    public String showForm(Model model) {
        model.addAttribute("artifact", new Artifact());
        model.addAttribute("artifactMainstat", new ArtifactMainstat());
        model.addAttribute("artifactSubstat1", new ArtifactSubstat());
        model.addAttribute("artifactSubstat2", new ArtifactSubstat());
        model.addAttribute("artifactSubstat3", new ArtifactSubstat());
        model.addAttribute("artifactSubstat4", new ArtifactSubstat());
        return "artifacts-save";
    }

    @PostMapping("/artifacts/save?{id}")
    public String saveArtifact( @ModelAttribute("artifact") Artifact artifact,
                                @ModelAttribute("artifactMainstat") ArtifactMainstat artifactMainstat,
                                @ModelAttribute("artifactSubstat1") ArtifactSubstat artifactSubstat1,
                                @ModelAttribute("artifactSubstat2") ArtifactSubstat artifactSubstat2,
                                @ModelAttribute("artifactSubstat3") ArtifactSubstat artifactSubstat3,
                                @ModelAttribute("artifactSubstat4") ArtifactSubstat artifactSubstat4,
                                @PathVariable("id") long id) {
        Set<ArtifactSubstat> substats = new LinkedHashSet<>();
        substats.add(artifactSubstat1);
        substats.add(artifactSubstat2);
        substats.add(artifactSubstat3);
        substats.add(artifactSubstat4);
        artifactService.saveArtifact(id, artifact, artifactMainstat, substats);
        return "artifact-save";
    }
}
