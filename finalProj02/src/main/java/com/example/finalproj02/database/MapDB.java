package com.example.finalproj02.database;

import com.example.finalproj02.model.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MapDB extends GameDB{
    public static MapDB instance=new MapDB();
    private final Building1DB building1DB;
    private final Building2DB building2DB;
    private final Building3DB building3DB;
    private final Building4DB building4DB;
    private final Building5DB building5DB;

    public static MapDB getInstance() {
        return instance;
    }

    private MapDB() {
        this.building1DB = Building1DB.getInstance();
        this.building2DB = Building2DB.getInstance();
        this.building3DB = Building3DB.getInstance();
        this.building4DB = Building4DB.getInstance();
        this.building5DB = Building5DB.getInstance();
    }

    public void insertMap(Map map) throws SQLException {
        super.setSQLCommand(String.format("INSERT INTO `maps` (`map-id`, `player-id`) VALUES (NULL, '%s')", map.getPlayerID()));
        executeSQLCommand();
        int mapID=findMapID(map.getPlayerID());
        super.setSQLCommand(String.format("UPDATE `players` SET `map-id`='%s' WHERE `players`.`player-id`='%s'", mapID, map.getPlayerID()));
        executeSQLCommand();
        for(Building a: map.getBuildings()){
            if(a instanceof Building1)
                building1DB.insertBuilding1(map.getMapID(), (Building1) a);
            else if(a instanceof Building2)
                building2DB.insertBuilding2(map.getMapID(), (Building2) a);
            else if(a instanceof Building3)
                building3DB.insertBuilding3(map.getMapID(), (Building3) a);
            else if(a instanceof Building4)
                building4DB.insertBuilding4(map.getMapID(), (Building4) a);
            else if(a instanceof Building5)
                building5DB.insertBuilding5(map.getMapID(), (Building5) a);
        }
    }

    private int findMapID(int playerID) throws SQLException {
        super.setSQLCommand(String.format("SELECT `map-id` FROM `maps` WHERE `maps`.`player-id`='%s'", playerID));
        ResultSet resultSet=executeQuerySQLCommand();
        int mapID=0;
        while (resultSet.next()){
            mapID=resultSet.getInt("map-id");
        }
        return mapID;
    }

    public ArrayList<Building> findMapBuilding(int mapID) throws SQLException {
        ArrayList<Building> buildings=new ArrayList<>();
        buildings.addAll(building1DB.findMapBuilding1s(mapID));
        buildings.addAll(building2DB.findMapBuilding2s(mapID));
        buildings.addAll(building3DB.findMapBuilding3s(mapID));
        buildings.addAll(building4DB.findMapBuilding4s(mapID));
        buildings.addAll(building5DB.findMapBuilding5s(mapID));
        return buildings;
    }

    public Map findMap(int playerID) throws SQLException {
        super.setSQLCommand(String.format("SELECT `map-id` FROM `maps` WHERE `maps`.`player-id`='%s'", playerID));
        ResultSet resultSet=executeQuerySQLCommand();
        int mapID=0;
        while (resultSet.next()){
            mapID=resultSet.getInt("map-id");
        }
        return new Map(mapID, playerID, findMapBuilding(mapID));
    }
}
