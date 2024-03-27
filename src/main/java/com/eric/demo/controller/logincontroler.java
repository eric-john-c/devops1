package com.eric.demo.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.eric.demo.domain.login;

import com.eric.demo.service.loginservice;
import com.eric.demo.service.registerservice;

@Controller

public class logincontroler {
 
    @Autowired
    private loginservice service;
    
 
    @GetMapping("/")
    public String api2()
    {
 
        return "log";
    }
 
    @PostMapping("/log")
    public String login(@ModelAttribute("user") login user) {
 
        login oauthUser = service.log(user.getUsername(), user.getPassword());
 
        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/home";
        } else {
            return "redirect:/";
        }
    }
 
    @GetMapping("/home")
    public String display() {
        return "home";
    }

    @Autowired
    private registerservice service2;



    @GetMapping("/register")
    public String api() {
        return "register";
    }

    @PostMapping("/register")
    public String Login(@ModelAttribute("user") login user) {
 
        login oauthUser = service2.saveUser(user.getUsername(), user.getPassword());
 
        System.out.print(oauthUser);
        if (Objects.nonNull(oauthUser)) {
            return "redirect:/display";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/display")
    public String disp() {
        return "display";
    }
}
