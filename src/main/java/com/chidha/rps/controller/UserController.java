package com.chidha.rps.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @PostMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

}
