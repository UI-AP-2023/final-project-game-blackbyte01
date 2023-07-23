package com.example.finalproj02.controller;

import com.example.finalproj02.database.MapDB;
import com.example.finalproj02.database.PlayersDB;
import com.example.finalproj02.exceptions.InvalidPasswordException;
import com.example.finalproj02.exceptions.PlayerNotFoundException;
import com.example.finalproj02.model.Map;
import com.example.finalproj02.model.Player;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlayerController {
    private final PlayersDB playersDB;
    private final MapDB mapDB;
    private static final PlayerController instance = new PlayerController();

    private PlayerController() {
        playersDB = PlayersDB.getInstance();
        mapDB = MapDB.getInstance();
    }

    public static PlayerController getInstance() {
        return instance;
    }

    public int signup(String username, String password, int level, int wonBattles, int lostBattles) throws SQLException, InvalidPasswordException {
        checkPasswordRegex(password);
        return playersDB.insertPlayer(new Player(username, password, level, wonBattles, lostBattles));
    }

    public Player login(String username, String password) throws SQLException, PlayerNotFoundException {
        Player player = playersDB.findPlayer(username, password);
        if (player == null)
            throw new PlayerNotFoundException();
        return playersDB.findPlayer(username, password);
    }

    public Player getPlayer(int playerID) throws SQLException {
        return playersDB.findPlayer(playerID);
    }

    public int getMinPlayerID() throws SQLException {
        return playersDB.findMinPlayerID();
    }

    public int getMaxPlayerID() throws SQLException {
        return playersDB.findMaxPlayerID();
    }

    public void checkPasswordRegex(String password) throws InvalidPasswordException {
        Pattern pattern1 = Pattern.compile("^\\S{8,12}$");
        Matcher matcher1 = pattern1.matcher(password);

        Pattern pattern2 = Pattern.compile("[A-Z]+");
        Matcher matcher2 = pattern2.matcher(password);

        Pattern pattern3 = Pattern.compile("[a-z]+");
        Matcher matcher3 = pattern3.matcher(password);

        Pattern pattern4 = Pattern.compile("\\d+");
        Matcher matcher4 = pattern4.matcher(password);

        Pattern pattern5 = Pattern.compile("([@#$%&*!])+");
        Matcher matcher5 = pattern5.matcher(password);

        if (!matcher1.find() || !matcher2.find() || !matcher3.find() || !matcher4.find() || !matcher5.find())
            throw new InvalidPasswordException();
    }
}
