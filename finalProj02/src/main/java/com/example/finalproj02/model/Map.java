package com.example.finalproj02.model;

import java.util.ArrayList;

public class Map {
    private int mapID;
    private int playerID;
    private final ArrayList<Building> buildings;

    public Map(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }

    public Map(int playerID, ArrayList<Building> buildings) {
        this.playerID = playerID;
        this.buildings = buildings;
    }

    public Map(int mapID, int playerID, ArrayList<Building> buildings) {
        this.mapID = mapID;
        this.playerID = playerID;
        this.buildings = buildings;
    }

    public int getMapID() {
        return mapID;
    }

    public int getPlayerID() {
        return playerID;
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }
}
