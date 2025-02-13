package me.ams.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgreSQL implements DatabaseConnectable{
    private static PostgreSQL instance;

    private String host;
    private String username;
    private String password;
    private String dbName;

    private Connection connection;

    private PostgreSQL() {}

    public static PostgreSQL getInstance() {
        if (instance == null) { instance = new PostgreSQL(); }
        return instance;
    }

    @Override
    public Connection getConnection() {
        String url = host + "/" + dbName;

        try {
            if (connection != null && !connection.isClosed()) return connection;

            connection = DriverManager.getConnection(url, username, password);
            return connection;
        }
        catch (SQLException e) {
            System.out.println("Unable to establish a connection with database: " + e.getMessage());
        }

        return null;
    }

    @Override
    public void closeConnection() {
        try {
            connection.close();
        }
        catch (SQLException e) {
            System.out.println("Unable to close a connection: " + e.getMessage());
        }
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }
}
