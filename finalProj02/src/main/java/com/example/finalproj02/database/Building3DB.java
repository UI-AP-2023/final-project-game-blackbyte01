package com.example.finalproj02.database;

import com.example.finalproj02.model.Building3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Building3DB extends GameDB{
    public static Building3DB instance=new Building3DB();
    
    private Building3DB() {}

    public static Building3DB getInstance() {
        return instance;
    }

    public void insertBuilding3(int mapID, Building3 building3){
        super.setSQLCommand(String.format("INSERT INTO `building3s`(`map-id`, `x`, `y`, `width`, `height`) VALUES ('%s','%s','%s','%s','%s')", mapID, building3.getX(), building3.getY(), building3.getWidth(), building3.getHeight()));
        executeSQLCommand();
    }

    public ArrayList<Building3> findMapBuilding3s(int mapID) throws SQLException {
        super.setSQLCommand(String.format("SELECT * FROM `building1s` WHERE `building1s`.`map-id`='%s'", mapID));
        ResultSet resultSet=executeQuerySQLCommand();
        ArrayList<Building3> building3s=new ArrayList<>();
        while (resultSet.next()){
            building3s.add(new Building3(resultSet.getDouble("x"), resultSet.getDouble("y"), resultSet.getDouble("width"), resultSet.getDouble("height")));
        }
        return building3s;
    }
}
