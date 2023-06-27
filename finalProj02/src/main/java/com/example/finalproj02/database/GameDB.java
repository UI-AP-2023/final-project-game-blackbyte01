package com.example.finalproj02.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

abstract public class GameDB {
    private final Connection connection;
    private Statement statement;
    private String SQLCommand;

    public GameDB(Connection connection){
        this.connection=connection;
    }

    public Connection getConnection() {
        return connection;
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

    public boolean executeSQLCommand(){   // executeUpdate() method
        try {
            statement=connection.prepareStatement(SQLCommand);
            return statement.execute(SQLCommand);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuerySQLCommand(){
        try {
            statement=connection.prepareStatement(SQLCommand);
            return statement.executeQuery(SQLCommand);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
