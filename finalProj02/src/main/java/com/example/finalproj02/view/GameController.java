package com.example.finalproj02.view;

import com.example.finalproj02.controller.GameGroundController;
import com.example.finalproj02.controller.MapController;
import com.example.finalproj02.model.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    private AnchorPane gameAnchorPane;
    @FXML
    private Pane resultPane;
    Map selectedMap;
    HashMap<Hero, Integer> selectedHeroes;
    MapController mapController;
    Audio audio;

    GameGroundController gameGroundController;
    com.example.finalproj02.controller.GameController gameController;

    void show0() {
        gameGroundController.setGameGround(selectedMap, selectedHeroes, gameAnchorPane);
        gameGroundController.loadSelectedMap();
        gameGroundController.loadSelectedHeroes();
        gameController.setGame(gameGroundController.getGameGround(), resultPane);
        gameController.startTimeLine();
        gameController.startTimeLine0();
        gameController.makeAllDraggable();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mapController = MapController.getInstance();
        audio = new Audio();
        audio.getGameAudioEffect().play();

        gameGroundController = GameGroundController.getInstance();
        gameController = com.example.finalproj02.controller.GameController.getInstance();
    }
}
