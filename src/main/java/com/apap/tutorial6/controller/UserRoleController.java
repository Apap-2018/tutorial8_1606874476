package com.apap.tutorial6.controller;

import com.apap.tutorial6.model.UserRoleModel;
import com.apap.tutorial6.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserRoleController {

    @Autowired
    private UserRoleService userService;

    @PostMapping("/addUser")
    private String addUserSubmit(@ModelAttribute UserRoleModel user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    private String updatePasswordSubmit(String username, String passwordLama, String passwordBaru) {
        UserRoleModel user = userService.findUserByUsername(username);
        user.setPassword(passwordBaru);

        //Tes
        System.out.println("Username: " + username);
        System.out.println("Password Lama: " + passwordLama);
        System.out.println("Password Lama Hash: " + userService.encrypt(passwordLama));
        System.out.println("Password Baru: " + user.getPassword());
        System.out.println("Password Baru Hash: " + userService.encrypt(passwordBaru));

        userService.addUser(user);
        return "home";
    }
}