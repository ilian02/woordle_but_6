package com.example.woordle.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RandomWorldController {

    @GetMapping("/random")
    public String randomPage() {
        return "random";
    }

    @GetMapping("/random/generate")
    public ResponseEntity<Map<String, String>> generateRandomWord() {
        Map<String, String> response = new HashMap<>();
        response.put("word", "tempest");
        return ResponseEntity.ok(response);
    }

}
