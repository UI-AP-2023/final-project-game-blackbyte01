package com.example.finalproj02.database;

import com.example.finalproj02.model.Building5;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Building5DB extends GameDB {
    public static Building5DB instance = new Building5DB();

    public Building5DB() {
    }

    public static Building5DB getInstance() {
        return instance;
    }

    public void insertBuilding5(int mapID, Building5 building5) {
        super.setSQLCommand(String.format("INSERT INTO `building5s`(`map-id`, `x`, `y`, `width`, `height`) VALUES ('%s','%s','%s','%s','%s')", mapID, building5.getMinX(), building5.getMinY(), building5.getImageView().getFitWidth(), building5.getImageView().getFitHeight()));
        executeSQLCommand();
    }

    public ArrayList<Building5> findMapBuilding5s(int mapID) throws SQLException {
        super.setSQLCommand(String.format("SELECT * FROM `building5s` WHERE `building5s`.`map-id`='%s'", mapID));
        ResultSet resultSet = executeQuerySQLCommand();
        ArrayList<Building5> building5s = new ArrayList<>();
        while (resultSet.next()) {
            building5s.add(new Building5(resultSet.getDouble("x"), resultSet.getDouble("y"), resultSet.getDouble("width"), resultSet.getDouble("height")));
        }
        return building5s;
    }
}
