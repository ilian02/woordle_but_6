package com.example.woordle.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Game {
    private String targetWord;
    private int attemtsLeft;
    private boolean gameOver;
    private List<Guess> guesses;
}
