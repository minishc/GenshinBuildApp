package com.tek.genshinbuildapp.controller;

import com.tek.genshinbuildapp.dao.AuthGroupRepository;
import com.tek.genshinbuildapp.dto.UserDto;
import com.tek.genshinbuildapp.model.AuthGroup;
import com.tek.genshinbuildapp.model.User;
import com.tek.genshinbuildapp.service.CharacterService;
import com.tek.genshinbuildapp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
@Slf4j
@SessionAttributes("principaluser")
public class HomeController {

    private final CharacterService characterService;
    private final UserService userService;
    private final AuthGroupRepository authGroupRepository;

    @Autowired
    public HomeController(CharacterService characterService,
                          UserService userService,
                          AuthGroupRepository authGroupRepository) {
        this.characterService = characterService;
        this.userService = userService;
        this.authGroupRepository = authGroupRepository;
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

    @GetMapping("/register")
    public String registerPage(Model model) {
        UserDto newUser = new UserDto();
        model.addAttribute("newUser", newUser);
        return "register";
    }

    @PostMapping("/register")
    public String saveNewUser(@ModelAttribute("newUser") UserDto user, BindingResult result,
                              RedirectAttributes attributes) {
        if(!result.hasErrors()) {
            try {
                log.info(user.getPassword());
                userService.saveUser(new User(user.getUsername(), user.getPassword()));
                authGroupRepository.save(new AuthGroup(user.getUsername(), "ROLE_USER"));
                return "redirect:/";
            }
            catch (Exception exc) {
                attributes.addFlashAttribute("message", "Username is taken.");
                return "redirect:/login";
            }
        }
        else {
            attributes.addFlashAttribute("message", "There was an error registering user " + user);
            return "redirect:/error";
        }
    }

    @GetMapping("/error")
    public String errorPage(Model model, RedirectAttributes attributes) {
        model.addAttribute("message", attributes.getFlashAttributes().get("message"));
        return "error";
    }
}
