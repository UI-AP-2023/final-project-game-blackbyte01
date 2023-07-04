package com.example.finalproj02.view;

import com.example.finalproj02.model.*;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GameController implements Initializable {
    @FXML
    private AnchorPane gameAnchorPane;
    @FXML
    private AnchorPane gameGroundAnchorPane;
    @FXML
    private VBox heroesVBox;
    Map map;
    ArrayList<Hero> heroes;
    @FXML
    private Label resultLbl;
    @FXML
    private AnchorPane resultPane;
    void show(Map map, ArrayList<Hero> heroes){
        this.map=map;
        this.heroes=heroes;
        //System.out.println(heroes);
        System.out.println("game controller: " +  map.getBuildings().size());
        GameGround gameGround=new GameGround(map, gameAnchorPane);
        Game game=new Game(gameAnchorPane, resultLbl, gameGround, heroes);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*
        GameGround gameGround=new GameGround(map, gameAnchorPane);
        ArrayList<Hero> heroes=new ArrayList<>();
        heroes.add(new Hero1(10, 10, 50, 50));
        heroes.add(new Hero2(120, 10, 50, 50));
        Game game=new Game(gameAnchorPane, gameGround, heroes);
         */
        /*
        ArrayList<Building> buildings=new ArrayList<>();
        ArrayList<Hero> heroes=new ArrayList<>();
        buildings.add(new Building1(500, 300, 100, 100));
        buildings.add(new Building2(300, 300, 100, 100));
        buildings.add(new Building3(100, 500, 100, 100));
        buildings.add(new Building4(500, 500, 100, 100));
        buildings.add(new Building3(400, 400, 100, 100));
        heroes.add(new Hero1(10, 10, 50, 50));
        heroes.add(new Hero2(10, 10, 50, 50));
        heroes.add(new Hero3(10, 10, 50, 50));
        heroes.add(new Hero4(10, 10, 50, 50));
        Map map=new Map(buildings);

        System.out.println(map.getBuildings());
        GameGround gameGround=new GameGround(map, gameAnchorPane);
        Game game=new Game(gameAnchorPane, resultPane, gameGround, heroes);
         */
    }
}
