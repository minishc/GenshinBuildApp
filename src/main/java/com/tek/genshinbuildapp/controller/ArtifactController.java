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

import java.security.Principal;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Controller
@Slf4j
public class ArtifactController {

    //services used in the controller to be autowired
    private final ArtifactService artifactService;
    private final UserService userService;

    @Autowired
    public ArtifactController(ArtifactService artifactService,
                              UserService userService) {
        this.artifactService = artifactService;
        this.userService = userService;
    }

    /*
        A mapping for showing all the artifacts that a User has uploaded
     */
    @GetMapping("/artifacts")
    public String artifactHome(Model model, Principal principal) {
        User user = new User();
        if(principal != null) {
            user = userService.retrieveUser(principal.getName());
        }
        model.addAttribute("user", user);
        model.addAttribute("artifacts", artifactService.retrieveArtifacts(user));
        return "artifacts";
    }

    /*
        Mapping for creating an artifact page, uses a dto because each artifact is a combination
        of entries in 3 different tables
     */
    @GetMapping("/artifacts/save")
    public String showForm(Model model) {
        model.addAttribute("artifactdto", new ArtifactDto());
        return "artifacts-save";
    }

    /*
        Mapping for submitting a single artifact upload
     */
    @PostMapping("/artifacts/save")
    public String saveArtifact(@ModelAttribute("artifactdto")ArtifactDto artifactDto,
                               Principal principal) {
        Set<ArtifactSubstat> substats = new LinkedHashSet<>();
        log.info(artifactDto.toString());
        Artifact artifact = new Artifact(artifactDto.getSlot(), artifactDto.getSet());
        ArtifactMainstat mainstat = new ArtifactMainstat(artifactDto.getStatNames()[0], artifactDto.getStatValues()[0]);
        for(int i = 1; i < 5; i++) {
            substats.add(new ArtifactSubstat(artifactDto.getStatNames()[i], artifactDto.getStatValues()[i]));
        }
        artifactService.saveArtifact(userService.retrieveUser(principal.getName()).getId(), artifact, mainstat, substats);
        return "redirect:/artifacts/save";
    }

    /*
        Mapping for submitting a csv file that uploads all artifacts in the file
     */
    @PostMapping("/artifacts/upload")
    public String parseUpload(@RequestParam("file-upload")MultipartFile file,
                              Principal principal) {
        User user = userService.retrieveUser(principal.getName());
        if(!file.isEmpty()) {
            List<ArtifactDto> dtos = ArtifactUtility.parseFile(file, user.getId());
            artifactService.saveFromDtoList(dtos);
        }
        return "redirect:/artifacts";
    }

    /*
        Mapping for deleting an artifact
     */
    @PostMapping("/artifacts/delete/{id}")
    public String deleteArtifact(@PathVariable("id") long id) {
        artifactService.deleteArtifact(id);
        return "redirect:/artifacts";
    }
}
