package com.devglan.controller;

import com.devglan.model.CurrentUser;
import com.devglan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(@Autowired final UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUser(@AuthenticationPrincipal CurrentUser currentUser) {
        System.out.println(currentUser);
        return "success";
    }

}
