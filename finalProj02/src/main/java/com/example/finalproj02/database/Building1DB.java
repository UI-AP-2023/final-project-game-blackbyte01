package com.example.finalproj02.database;

import com.example.finalproj02.model.Building1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Building1DB extends GameDB{
    public static Building1DB instance=new Building1DB();

    private Building1DB() {}

    public static Building1DB getInstance() {
        return instance;
    }

    public void insertBuilding1(int mapID, Building1 building1){
        super.setSQLCommand(String.format("INSERT INTO `building1s`(`map-id`, `x`, `y`, `width`, `height`) VALUES ('%s','%s','%s','%s','%s')", mapID, building1.getMinX(), building1.getMinY(), building1.getImageView().getFitWidth(), building1.getImageView().getFitHeight()));
        executeSQLCommand();
    }

    public ArrayList<Building1> findMapBuilding1s(int mapID) throws SQLException {
        super.setSQLCommand(String.format("SELECT * FROM `building1s` WHERE `building1s`.`map-id`='%s'", mapID));
        ResultSet resultSet=executeQuerySQLCommand();
        ArrayList<Building1> building1s=new ArrayList<>();
        while (resultSet.next()){
            building1s.add(new Building1(resultSet.getDouble("x"), resultSet.getDouble("y"), resultSet.getDouble("width"), resultSet.getDouble("height")));
        }
        return building1s;
    }
}
