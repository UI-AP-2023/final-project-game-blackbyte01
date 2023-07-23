package com.example.finalproj02.database;

import com.example.finalproj02.model.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayersDB extends GameDB {
    public static PlayersDB instance = new PlayersDB();
    private final MapDB mapDB;

    private PlayersDB() {
        mapDB = MapDB.getInstance();
    }

    public static PlayersDB getInstance() {
        return instance;
    }

    public MapDB getMapDB() {
        return mapDB;
    }

    public int insertPlayer(Player player) throws SQLException {
        super.setSQLCommand(String.format("INSERT INTO `players` (`player-id`, `username`, `nickname`,  `password`, `level`, `won-battles`, `lost-battles`, `map-id`) VALUES (NULL, '%s', '%s', '%s', '%s', '%s', '%s', '%s')", player.getUsername(), "player", player.getPassword(), player.getLevel(), player.getWonBattles(), player.getLostBattles(), 1));
        executeSQLCommand();
        return findPlayerID(player.getUsername());
    }

    private int findPlayerID(String username) throws SQLException {
        super.setSQLCommand(String.format("SELECT `player-id` FROM `players` WHERE `players`.`username`='%s'", username));
        ResultSet resultSet = executeQuerySQLCommand();
        int playerID = 0;
        while (resultSet.next()) {
            playerID = resultSet.getInt("player-id");
        }
        return playerID;
    }

    public Player findPlayer(String username, String password) throws SQLException {
        super.setSQLCommand(String.format("SELECT `player-id`, `username`, `nickname`, `password`, `level`, `won-battles`, `lost-battles` FROM `players` WHERE `players`.`username`='%s' AND `players`.`password`='%s'", username, password));
        ResultSet resultSet = executeQuerySQLCommand();
        Player player = null;
        while (resultSet.next()) {
            player = new Player(resultSet.getInt("player-id"), resultSet.getString("username"), resultSet.getString("nickname"), resultSet.getString("password"), resultSet.getInt("level"), resultSet.getInt("won-battles"), resultSet.getInt("lost-battles"));
        }
        return player;
    }

    public int findMinPlayerID() throws SQLException {
        super.setSQLCommand("SELECT MIN(`players`.`player-id`) FROM `players`");
        ResultSet resultSet = executeQuerySQLCommand();
        int playerID = 0;
        while (resultSet.next()) {
            playerID = resultSet.getInt(1);
        }
        return playerID;
    }

    public int findMaxPlayerID() throws SQLException {
        super.setSQLCommand("SELECT MAX(`players`.`player-id`) FROM `players`");
        ResultSet resultSet = executeQuerySQLCommand();
        int playerID = 0;
        while (resultSet.next()) {
            playerID = resultSet.getInt(1);
        }
        return playerID;
    }

    public Player findPlayer(int playerID) throws SQLException {
        super.setSQLCommand(String.format("SELECT `player-id`, `username`, `nickname`, `password`, `level`, `won-battles`, `lost-battles` FROM `players` WHERE `players`.`player-id`='%s'", playerID));
        ResultSet resultSet = executeQuerySQLCommand();
        Player player = null;
        while (resultSet.next()) {
            player = new Player(resultSet.getInt("player-id"), resultSet.getString("username"), resultSet.getString("nickname"), resultSet.getString("password"), resultSet.getInt("level"), resultSet.getInt("won-battles"), resultSet.getInt("lost-battles"));
        }
        return player;
    }
}
