package com.example.finalproj02.database;

import java.math.BigInteger;
import java.sql.Connection;

public class PlayersDB extends GameDB {

    public PlayersDB(Connection connection){
        super(connection);
    }

    public void insertPlayer(String username, String nickname, String password, int level, int mapID){  // change the order of map-id and battles both in here and database
        super.setSQLCommand(String.format("INSERT INTO `players` (`player-id`, `username`, `nickname`, `password`, `level`, `won-battles`, `lost-battles`, `map-id`) VALUES (NULL, '%s', '%s', '%s', '%s', '0', '0', '%s');", username, nickname, password, level, mapID));
        executeSQLCommand();
    }

    public void deleteUSerAccount(BigInteger playerID){
        super.setSQLCommand(String.format("DELETE FROM `players` WHERE `players`.`player-id` = %s", playerID));
        executeSQLCommand();
    }

    /*
    public Player findPlayer(String username, String password) throws SQLException {
        super.setSQLCommand(String.format("SELECT `player-id`, `username`, `nickname`, `password`, `level`, `won-battles`, `lost-battles`, `map-id` FROM `players` WHERE `players`.`username`='%s' AND `accounts`.`password`='%s'", username, password));
        ResultSet resultSet=executeQuerySQLCommand();
        Player player=null;
        while (resultSet.next()){
            player= new Player(resultSet.getString("player-id"), resultSet.getString("username"), resultSet.getString("nickname"), resultSet.getString("password"), resultSet.getInt("level"), resultSet.getInt("won-battles"), resultSet.getInt("lost-battles"), findMap(resultSet.getInt("map-id")));
        }
        return player;
    }
     */
}
