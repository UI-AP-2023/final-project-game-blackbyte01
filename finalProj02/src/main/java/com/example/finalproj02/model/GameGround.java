package com.example.finalproj02.model;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.HashMap;

public class GameGround {
    private final Map selectedMap;
    private final HashMap<Hero, Integer> selectedHeroes;
    private final ArrayList<Hero> playingHeroes;
    private final Pane gamePane;
    private final double firstTotalHealth;

    public GameGround(Map selectedMap, HashMap<Hero, Integer> selectedHeroes, Pane gamePane) {
        this.selectedMap = selectedMap;
        this.selectedHeroes = selectedHeroes;
        this.gamePane = gamePane;
        playingHeroes = new ArrayList<>();
        this.firstTotalHealth = calculateTotalBuildingHealth();
    }

    public double calculateTotalBuildingHealth() {
        double totalHealth = 0;
        for (Building a : selectedMap.getBuildings()) {
            if (a.getHealth() > 0) {
                totalHealth += a.getHealth();
            }
        }
        return totalHealth;
    }

    public double getFirstTotalHealth() {
        return firstTotalHealth;
    }

    public Map getSelectedMap() {
        return selectedMap;
    }

    public HashMap<Hero, Integer> getSelectedHeroes() {
        return selectedHeroes;
    }

    public Pane getGamePane() {
        return gamePane;
    }

    public ArrayList<Hero> getPlayingHeroes() {
        return playingHeroes;
    }

}
