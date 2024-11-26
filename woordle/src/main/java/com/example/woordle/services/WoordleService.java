package com.example.woordle.services;

import com.example.woordle.Models.Game;
import com.example.woordle.Models.Guess;
import org.springframework.stereotype.Service;

@Service
public class WoordleService {
    private String targetWord;
    private int maxAttemps = 7;

    public Game startGame() {
        return new Game();
    }
    public Guess processGuess(String guessWord) {
        return new Guess();
    }
}
