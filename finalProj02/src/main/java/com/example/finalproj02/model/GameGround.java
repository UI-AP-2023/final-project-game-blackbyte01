package com.example.finalproj02.model;

import com.example.finalproj02.controller.HeroController;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class GameGround {
    private final ArrayList<Hero> heroes;
    private final Map map;
    private final Pane pane;
    public GameGround(Map map, Pane pane){
        heroes=new ArrayList<>();
        this.map=map;
        this.pane=pane;
        //loadMap(pane);
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public Map getMap() {
        return map;
    }

    public Pane getPane() {
        return pane;
    }

    public ArrayList<Building> loadMap(Pane pane){
        System.out.println("game ground: " + map.getBuildings().size());
        ArrayList<Building> buildings = new ArrayList<>(map.getBuildings());
        for(Building a: buildings){
            pane.getChildren().add(a.getImageView());
        }
        return buildings;
    }
}
