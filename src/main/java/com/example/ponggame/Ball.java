package com.example.ponggame;

import java.util.Random;

public class Ball extends Object {

    public static final int BALL_R = 15;
    private int XSpeed;
    private int YSpeed;
    public Ball(double XPos, double YPos) {
        super(XPos, YPos);
        setXSpeed(new Random().nextInt(2) == 0 ? 1 : -1);
        setYSpeed(new Random().nextInt(2) == 0 ? 1 : -1);
        width = height = BALL_R;
    }

    public Ball() {
        super(INFO.WIDTH / 2, INFO.HEIGHT / 2);
        setXSpeed(new Random().nextInt(2) == 0 ? 1 : -1);
        setYSpeed(new Random().nextInt(2) == 0 ? 1 : -1);
        width = height = BALL_R;
    }

    public int getXSpeed() {
        return XSpeed;
    }

    public void setXSpeed(int XSpeed) {
        this.XSpeed = XSpeed;
    }

    public int getYSpeed() {
        return YSpeed;
    }

    public void setYSpeed(int YSpeed) {
        this.YSpeed = YSpeed;
    }

    public void changeDirection(boolean horizontalHit, boolean verticalHit) {
        if (horizontalHit) XSpeed *= -1;
        if (verticalHit) YSpeed *= -1;
    }

    public void move() {
        XPos += XSpeed;
        YPos += YSpeed;
    }
    public void increaseSpeed() {
        XSpeed += 1 * Math.signum(XSpeed);
        YSpeed += 1 * Math.signum(YSpeed);
    }
    public void reset(int xPos, int yPos) {
        setXPos(xPos);
        setYPos(yPos);
        setXSpeed(new Random().nextInt(2) == 0 ? 1 : -1);
        setYSpeed(new Random().nextInt(2) == 0 ? 1 : -1);
    }
}
