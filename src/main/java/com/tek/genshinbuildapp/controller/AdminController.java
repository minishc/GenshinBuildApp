package com.tek.genshinbuildapp.controller;

import com.tek.genshinbuildapp.dao.AuthGroupRepository;
import com.tek.genshinbuildapp.dto.UserAuthGroupDto;
import com.tek.genshinbuildapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminController {

    private final UserService userService;
    private final AuthGroupRepository authGroupRepository;

    @Autowired
    public AdminController(UserService userService,
                           AuthGroupRepository authGroupRepository) {
        this.userService = userService;
        this.authGroupRepository = authGroupRepository;
    }

    @GetMapping("/admin/users")
    public String showUsers(Model model) {
        List<UserAuthGroupDto> users = new ArrayList<>();
        userService.retrieveUsers().forEach(user ->
                users.add(new UserAuthGroupDto(user, authGroupRepository.findAllByUsername(user.getUsername()))));
        model.addAttribute("users", users);
        return "users";
    }
}
