package com.tek.genshinbuildapp.controller;

import com.tek.genshinbuildapp.dto.ArtifactDto;
import com.tek.genshinbuildapp.model.Artifact;
import com.tek.genshinbuildapp.model.ArtifactMainstat;
import com.tek.genshinbuildapp.model.ArtifactSubstat;
import com.tek.genshinbuildapp.service.ArtifactService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
        model.addAttribute("artifactdto", new ArtifactDto());
        return "artifacts-save";
    }

    @PostMapping("/artifacts/save")
    public String saveArtifact(@ModelAttribute("artifactdto")ArtifactDto artifactDto) {
        Set<ArtifactSubstat> substats = new LinkedHashSet<>();
        log.info(artifactDto.toString());
        Artifact artifact = new Artifact(artifactDto.getSlot(), artifactDto.getSet());
        ArtifactMainstat mainstat = new ArtifactMainstat(artifactDto.getStatNames()[0], artifactDto.getStatValues()[0]);
        for(int i = 1; i < 5; i++) {
            substats.add(new ArtifactSubstat(artifactDto.getStatNames()[i], artifactDto.getStatValues()[i]));
        }
        artifactService.saveArtifact(1, artifact, mainstat, substats);
        return "redirect:/artifacts/save";
    }
}
