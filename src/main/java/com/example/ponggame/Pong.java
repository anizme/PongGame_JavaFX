package com.example.ponggame;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Pong extends Application {

    Ball ball;
    Player p1;
    Player p2;

    private boolean gameStarted;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        ball = new Ball(INFO.WIDTH / 2, INFO.HEIGHT / 2);
        p1 = new Player(0, INFO.HEIGHT / 2);
        p2 = new Player(INFO.WIDTH - Player.PLAYER_WIDTH, INFO.HEIGHT / 2);

        stage.setTitle("PONG");
        Canvas canvas = new Canvas(INFO.WIDTH, INFO.HEIGHT);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), e -> {
            run(graphicsContext);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);

        //mouse control
        canvas.setOnMouseMoved(e -> {
            p1.setYPos(e.getY() - Player.PLAYER_HEIGHT / 2);
        });
        canvas.setOnMouseClicked(e -> gameStarted = true);
        stage.setScene(new Scene(new StackPane(canvas)));
        stage.show();
        timeline.play();
    }

    private void run(GraphicsContext graphicsContext) {
        //set background color
        graphicsContext.setFill(Color.PINK);
        graphicsContext.fillRect(0, 0, INFO.WIDTH, INFO.HEIGHT);

        //set text color
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.setFont(Font.font(25));

        if (gameStarted) {
            //set ball movement
            ball.move();

            //computer
            if (ball.getXPos() < INFO.WIDTH - INFO.WIDTH / 7) {
                p2.setYPos(ball.getYPos() - Player.PLAYER_HEIGHT / 2);
            } else {
                p2.setYPos(ball.getYPos() > p2.getYPos() + Player.PLAYER_HEIGHT / 2 ? p2.getYPos() + 3 : p2.getYPos() - 3);
            }

            //draw ball
            graphicsContext.fillOval(ball.getXPos(), ball.getYPos(), Ball.BALL_R, Ball.BALL_R);

        } else {
            //set the start text
            graphicsContext.setStroke(Color.WHITE);
            graphicsContext.setTextAlign(TextAlignment.CENTER);
            graphicsContext.strokeText("Click to start", INFO.WIDTH / 2, INFO.HEIGHT / 2);

            //reset the ball
            ball.reset(INFO.WIDTH / 2, INFO.HEIGHT / 2);

        }

        //ball stays in canvas
        if (ball.getYPos() <= 0 || ball.getYPos() + Ball.BALL_R >= INFO.HEIGHT) {
            ball.changeDirection(false, true);
        }

        //p2 gets score
        if (ball.getXPos() <= 0) {
            p2.increaseScore();
            gameStarted = false;
        }
        //p1 gets point
        if (ball.getXPos() + Ball.BALL_R >= INFO.WIDTH) {
            p1.increaseScore();
            gameStarted = false;
        }

        if (p1.isHitBall(ball)) {
            System.out.println("true1");
            ball.changeDirection(true, false);
            ball.increaseSpeed();
        }
        if (p2.isHitBall(ball)) {
            System.out.println("true2");
            ball.changeDirection(true, false);
            ball.increaseSpeed();
        }

        //draw score
        graphicsContext.fillText(p1.getScore() + "\t\t\t\t" + p2.getScore(), INFO.WIDTH / 2, 100);

        graphicsContext.strokeLine(INFO.WIDTH / 2, 0, INFO.WIDTH / 2, INFO.HEIGHT);
        //draw p1, p2
        graphicsContext.setFill(Color.BLUE);
        graphicsContext.fillRect(p2.getXPos(), p2.getYPos(), Player.PLAYER_WIDTH, Player.PLAYER_HEIGHT);
        graphicsContext.setFill(Color.RED);
        graphicsContext.fillRect(p1.getXPos(), p1.getYPos(), Player.PLAYER_WIDTH, Player.PLAYER_HEIGHT);

    }
}
