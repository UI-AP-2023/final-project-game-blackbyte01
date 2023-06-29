package com.example.finalproj02.database;

import com.example.finalproj02.model.Building2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Building2DB extends GameDB{
    public static Building2DB instance=new Building2DB();

    private Building2DB() {}

    public static Building2DB getInstance() {
        return instance;
    }

    public void insertBuilding2(int mapID, Building2 building2){
        super.setSQLCommand(String.format("INSERT INTO `building2s`(`map-id`, `x`, `y`, `width`, `height`) VALUES ('%s','%s','%s','%s','%s')", mapID, building2.getX(), building2.getY(), building2.getWidth(), building2.getHeight()));
        executeSQLCommand();
    }

    public ArrayList<Building2> findMapBuilding2s(int mapID) throws SQLException {
        super.setSQLCommand(String.format("SELECT * FROM `building1s` WHERE `building1s`.`map-id`='%s'", mapID));
        ResultSet resultSet=executeQuerySQLCommand();
        ArrayList<Building2> building2s=new ArrayList<>();
        while (resultSet.next()){
            building2s.add(new Building2(resultSet.getDouble("x"), resultSet.getDouble("y"), resultSet.getDouble("width"), resultSet.getDouble("height")));
        }
        return building2s;
    }
}
