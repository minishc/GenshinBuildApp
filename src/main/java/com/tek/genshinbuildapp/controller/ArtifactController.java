package com.tek.genshinbuildapp.controller;

import com.tek.genshinbuildapp.dto.ArtifactDto;
import com.tek.genshinbuildapp.model.Artifact;
import com.tek.genshinbuildapp.model.ArtifactMainstat;
import com.tek.genshinbuildapp.model.ArtifactSubstat;
import com.tek.genshinbuildapp.model.User;
import com.tek.genshinbuildapp.service.ArtifactService;
import com.tek.genshinbuildapp.service.UserService;
import com.tek.genshinbuildapp.utility.ArtifactUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Controller
@Slf4j
public class ArtifactController {

    private ArtifactService artifactService;
    private UserService userService;

    @Autowired
    public ArtifactController(ArtifactService artifactService,
                              UserService userService) {
        this.artifactService = artifactService;
        this.userService = userService;
    }

    @GetMapping("/artifacts")
    public String artifactHome(Model model) {
        User user = userService.retrieveUser(1);
        model.addAttribute("user", user);
        model.addAttribute("artifacts", artifactService.retrieveArtifacts(user));
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
        artifactService.saveArtifact(1L, artifact, mainstat, substats);//TODO: When implementing security make this based on the principal
        return "redirect:/artifacts/save";
    }

    @PostMapping("/artifacts/upload")
    public String parseUpload(@RequestParam("file-upload")MultipartFile file) {
        if(!file.isEmpty()) {
            List<ArtifactDto> dtos = ArtifactUtility.parseFile(file, 1L);//TODO: When implementing security make this based on the principal
            artifactService.saveFromDtoList(dtos);
        }
        return "redirect:/artifacts";
    }

    @PostMapping("/artifacts/delete/{id}")
    public String deleteArtifact(@PathVariable("id") long id) {
        artifactService.deleteArtifact(id);
        return "redirect:/artifacts";
    }
}
