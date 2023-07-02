package com.example.finalproj02.model;

public class Player {
    private int playerID;
    private String nickname;
    private final String username;
    private String password;
    private int level;
    private int wonBattles;
    private int lostBattles;
    private Map map;

    public Player(int playerID, String username, String nickname, String password, int level, int wonBattles, int lostBattles, Map map){
        this.playerID=playerID;
        this.username=username;
        this.nickname=nickname;
        this.password=password;
        this.wonBattles=wonBattles;
        this.lostBattles=lostBattles;
        this.level=level;
        this.map=map;
    }

    public Player(String username, String password, int level, int wonBattles, int lostBattles){
        this.username=username;
        this.password=password;
        this.wonBattles=wonBattles;
        this.lostBattles=lostBattles;
        this.level=level;
    }

    public Player(int playerID, String username, String nickname, String password, int level, int wonBattles, int lostBattles){
        this.playerID=playerID;
        this.username=username;
        this.nickname=nickname;
        this.password=password;
        this.wonBattles=wonBattles;
        this.lostBattles=lostBattles;
        this.level=level;
    }

    public int getPlayerID() {
        return playerID;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getWonBattles() {
        return wonBattles;
    }

    public void setWonBattles(int wonBattles) {
        this.wonBattles = wonBattles;
    }

    public int getLostBattles() {
        return lostBattles;
    }

    public void setLostBattles(int lostBattles) {
        this.lostBattles = lostBattles;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public String toString() {
        if(map==null){
            return "ID: " + playerID +
                    "\nusername:  " + username +
                    "\npassword:  " + password +
                    "\nnickname:  " + nickname +
                    "\nlevel:  " + level +
                    "\nwon plays:  " + wonBattles +
                    "\nlost plays:  " + lostBattles;
        }
        return "ID: " + playerID +
                "\nusername:  " + username +
                "\npassword:  " + password +
                "\nnickname:  " + nickname +
                "\nlevel:  " + level +
                "\nwon plays:  " + wonBattles +
                "\nlost plays:  " + lostBattles +
                "\nmap ID:  " + map.getMapID();
    }
}
