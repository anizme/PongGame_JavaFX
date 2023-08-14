package com.example.ponggame;

import javafx.scene.shape.Rectangle;

public class Collision {
    public static boolean checkCollision(Rectangle rec1, Rectangle rec2) {
        double x1 = rec1.getX(), y1 = rec1.getY();
        double x2 = rec2.getX(), y2 = rec2.getY();
        double width1 = rec1.getWidth(), height1 = rec1.getHeight();
        double width2 = rec2.getWidth(), height2 = rec2.getHeight();

        if (!(x1 > x2 + width2 || x1 + width1 < x2)) {

            if (!(y1 > y2 + height2 || y1 + height1 < y2)) {
                return true;
            }
        }
        return false;
    }
}
