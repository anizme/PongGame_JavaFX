package com.example.ponggame;

import javafx.scene.shape.Rectangle;

public class Object {
    protected double XPos;
    protected double YPos;
    protected int width = 0;
    protected int height = 0;
    public Object(double XPos, double YPos) {
        this.XPos = XPos;
        this.YPos = YPos;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getXPos() {
        return XPos;
    }

    public void setXPos(double XPos) {
        this.XPos = XPos;
    }

    public double getYPos() {
        return YPos;
    }

    public void setYPos(double YPos) {
        this.YPos = YPos;
    }
    public Rectangle getRect() {
        return new Rectangle(XPos, YPos, width, height);
    }
}
