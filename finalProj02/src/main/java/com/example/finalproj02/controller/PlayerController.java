package com.example.finalproj02.controller;

import com.example.finalproj02.database.MapDB;
import com.example.finalproj02.database.PlayersDB;
import com.example.finalproj02.model.Map;
import com.example.finalproj02.model.Player;

import java.sql.SQLException;

public class PlayerController {
    private final PlayersDB playersDB;
    private final MapDB mapDB;
    private static PlayerController instance=new PlayerController();

    private PlayerController() {
        playersDB=PlayersDB.getInstance();
        mapDB=MapDB.getInstance();
    }

    public static PlayerController getInstance() {
        return instance;
    }

    public int signup(String username, String password, int level, int wonBattles, int lostBattles) throws SQLException {
        return playersDB.insertPlayer(new Player(username, password, level, wonBattles, lostBattles));
    }

    public Player login(String username, String password) throws SQLException {
        return playersDB.findPlayer(username, password);
    }
}
