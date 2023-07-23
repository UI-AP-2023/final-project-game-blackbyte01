package com.example.finalproj02.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

abstract public class GameDB {
    private DBConnection dbConnection;
    private Statement statement;
    private String SQLCommand;

    public GameDB() {
        try {
            dbConnection = new DBConnection("jdbc:mysql://localhost/game", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public DBConnection getDbConnection() {
        return dbConnection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public String getSQLCommand() {
        return SQLCommand;
    }

    public void setSQLCommand(String SQLCommand) {
        this.SQLCommand = SQLCommand;
    }

    public void executeSQLCommand() {   // executeUpdate() method
        try {
            statement = dbConnection.getConnection().prepareStatement(SQLCommand);
            statement.execute(SQLCommand);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuerySQLCommand() {
        try {
            statement = dbConnection.getConnection().prepareStatement(SQLCommand);
            return statement.executeQuery(SQLCommand);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
