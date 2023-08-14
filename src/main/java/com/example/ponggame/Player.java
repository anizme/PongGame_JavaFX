package com.example.ponggame;

import javafx.scene.shape.Rectangle;

public class Player extends Object {
    public static final int PLAYER_WIDTH = 15;
    public static final int PLAYER_HEIGHT = 100;
    private Score score;
    private Rectangle playerBody;
    //constructor
    public Player(int XPos, int YPos) {
        super(XPos, YPos);
        score = new Score(0);
        width = PLAYER_WIDTH;
        height = PLAYER_HEIGHT;
    }
    public Player(int XPos, int YPos, Score score) {
        super(XPos, YPos);
        this.score = score;
        width = PLAYER_WIDTH;
        height = PLAYER_HEIGHT;
    }
    //getter and setter
    public int getScore() {
        return score.getScoreValue();
    }
    public void setScore(int score) {
        this.score.setScoreValue(score);
    }
    //method
    public boolean isHitBall(Ball ball) {
        return Collision.checkCollision(getRect(), ball.getRect());
    }
    public void increaseScore() {
        score.setScoreValue(score.getScoreValue() + 1);
    }
}
