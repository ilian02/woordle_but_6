package com.example.woordle.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RandomWorldController {

    @GetMapping("/random")
    public String randomPage() {
        return "random";
    }

}
