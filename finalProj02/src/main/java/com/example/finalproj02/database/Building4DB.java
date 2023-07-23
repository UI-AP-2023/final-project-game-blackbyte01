package com.example.finalproj02.database;

import com.example.finalproj02.model.Building4;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Building4DB extends GameDB {
    public static Building4DB instance = new Building4DB();

    private Building4DB() {
    }

    public static Building4DB getInstance() {
        return instance;
    }

    public void insertBuilding4(int mapID, Building4 building4) {
        super.setSQLCommand(String.format("INSERT INTO `building4s`(`map-id`, `x`, `y`, `width`, `height`) VALUES ('%s','%s','%s','%s','%s')", mapID, building4.getMinX(), building4.getMinY(), building4.getImageView().getFitWidth(), building4.getImageView().getFitHeight()));
        executeSQLCommand();
    }

    public ArrayList<Building4> findMapBuilding4s(int mapID) throws SQLException {
        super.setSQLCommand(String.format("SELECT * FROM `building4s` WHERE `building4s`.`map-id`='%s'", mapID));
        ResultSet resultSet = executeQuerySQLCommand();
        ArrayList<Building4> building4s = new ArrayList<>();
        while (resultSet.next()) {
            building4s.add(new Building4(resultSet.getDouble("x"), resultSet.getDouble("y"), resultSet.getDouble("width"), resultSet.getDouble("height")));
        }
        return building4s;
    }
}
