package com.skha.springbootbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/app")

public class TokenController {

    @GetMapping(path = "/test")
    public String test(Principal principal) {
        return principal.getName();
    }
}
