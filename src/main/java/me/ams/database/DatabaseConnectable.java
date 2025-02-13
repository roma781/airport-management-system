package me.ams.database;

import java.sql.Connection;

public interface DatabaseConnectable {
    Connection getConnection();
    void closeConnection();

}
