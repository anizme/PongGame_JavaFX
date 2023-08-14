package com.example.ponggame;

public class Score {
    private int scoreValue;

    public Score() {
        scoreValue = 0;
    }
    public Score(int scoreValue) {
        this.scoreValue = scoreValue;
    }

    public int getScoreValue() {
        return scoreValue;
    }

    public void setScoreValue(int scoreValue) {
        this.scoreValue = scoreValue;
    }
}
