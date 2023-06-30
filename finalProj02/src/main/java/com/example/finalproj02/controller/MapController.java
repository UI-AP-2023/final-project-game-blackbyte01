package com.example.finalproj02.controller;

import com.example.finalproj02.database.MapDB;
import com.example.finalproj02.model.Building;
import com.example.finalproj02.model.Map;

import java.sql.SQLException;
import java.util.ArrayList;

public class MapController {
    public static MapController instance=new MapController();
    private final MapDB mapDB;
    private MapController(){
        mapDB=MapDB.getInstance();
    }

    public static MapController getInstance() {
        return instance;
    }
    public void saveNewMap(int playerID, ArrayList<Building> buildings) throws SQLException {
        mapDB.insertMap(new Map(playerID, buildings));
    }

    public Map findMap(int playerID) throws SQLException {
        return mapDB.findMap(playerID);
    }
}
