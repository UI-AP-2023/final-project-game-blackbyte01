package com.example.finalproj02.model;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class Game {
    private final GameGround gameGround0;
    private Timeline gameTimeline;
    private Timeline gameTimeLine0;
    private final Audio audio;
    private final Pane resultPane;
    private boolean gameIsOver = false;

    public Game(GameGround gameGround0, Pane resultPane) {
        this.gameGround0 = gameGround0;
        audio = new Audio();
        this.resultPane = resultPane;
    }

    public GameGround getGameGround0() {
        return gameGround0;
    }

    public Timeline getGameTimeline() {
        return gameTimeline;
    }

    public void setGameTimeline(Timeline gameTimeline) {
        this.gameTimeline = gameTimeline;
    }

    public Timeline getGameTimeLine0() {
        return gameTimeLine0;
    }

    public void setGameTimeLine0(Timeline gameTimeLine0) {
        this.gameTimeLine0 = gameTimeLine0;
    }

    public Audio getAudio() {
        return audio;
    }

    public Pane getResultPane() {
        return resultPane;
    }

    public boolean isGameIsOver() {
        return gameIsOver;
    }

    public void setGameIsOver(boolean gameIsOver) {
        this.gameIsOver = gameIsOver;
    }
}
