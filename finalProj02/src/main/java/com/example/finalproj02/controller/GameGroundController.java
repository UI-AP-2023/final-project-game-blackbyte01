package com.example.finalproj02.controller;

import com.example.finalproj02.model.*;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.HashMap;

public class GameGroundController {
    private GameGround gameGround;
    private static GameGroundController instance=new GameGroundController();
    private GameGroundController(){
    }
    public static GameGroundController getInstance() {
        return instance;
    }
    public GameGround getGameGround() {
        return gameGround;
    }

    public void setGameGround(Map selectedMap, HashMap<Hero, Integer> selectedHeroes, Pane gamePane) {
        this.gameGround = new GameGround(selectedMap, selectedHeroes, gamePane);
    }

    public void loadSelectedMap() {
        for (Building a : gameGround.getSelectedMap().getBuildings()) {
            gameGround.getGamePane().getChildren().add(a.getImageView());
            if (a instanceof DBuilding) {
                startAttackTimeLine((DBuilding) a);
            }
        }
    }

    public void startAttackTimeLine(DBuilding dBuilding) {
        dBuilding.getAttackTimeLine().setCycleCount(Animation.INDEFINITE);
        dBuilding.getAttackTimeLine().getKeyFrames().add(new KeyFrame(Duration.millis(10), e -> checkIsReached(dBuilding)));
        dBuilding.getAttackTimeLine().play();
    }

    public void checkIsReached(DBuilding dBuilding) {
        if (dBuilding.getHero() != null) {
            if (dBuilding.getDBuildingEquipment().isReached()) {
                gameGround.getGamePane().getChildren().remove(dBuilding.getDBuildingEquipment().getGroup());
                dBuilding.getHero().setHealth(dBuilding.getHero().getHealth() - dBuilding.getDamage());
            }
        }
    }

    public void loadSelectedHeroes() {
        int i = 0;
        for (java.util.Map.Entry<Hero, Integer> a : gameGround.getSelectedHeroes().entrySet()) {
            ((Pane) ((GridPane) gameGround.getGamePane().getChildren().get(1)).getChildren().get(i)).getChildren().add(a.getKey().getImageView());
            ((GridPane) gameGround.getGamePane().getChildren().get(1)).getChildren().get(i).setVisible(true);
            ++i;
        }
    }
}
