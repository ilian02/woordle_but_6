package com.example.woordle.controllers;

import org.json.JSONArray;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
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
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://random-word-api.herokuapp.com/word?length=6"))
                .build();

            HttpResponse<String> randomWordAPI = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONArray jsonArray = new JSONArray(randomWordAPI.body());

            String word = jsonArray.getString(0);
            response.put("word", word);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(response);
    }

}
