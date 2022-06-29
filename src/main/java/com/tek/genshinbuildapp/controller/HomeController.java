package com.tek.genshinbuildapp.controller;

import com.tek.genshinbuildapp.service.CharacterService;
import com.tek.genshinbuildapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@Slf4j
@SessionAttributes("principaluser")
public class HomeController {

    private final CharacterService characterService;
    private final UserService userService;

    @Autowired
    public HomeController(CharacterService characterService,
                          UserService userService) {
        this.characterService = characterService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage(Principal principal, HttpSession session, Model model) {
        try {
            if(principal != null) {
                session.setAttribute("principaluser", userService.retrieveUser(principal.getName()));
                log.info(userService.retrieveUser(principal.getName()).toString() + " logged in");
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        model.addAttribute("characters", characterService.retrieveCharacters());
        return "index";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/logout/success")
    public String logoutHandling(SessionStatus session) {
        session.setComplete();
        return "redirect:/";
    }
}
