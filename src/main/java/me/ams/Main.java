package me.ams;

import me.ams.database.Database;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();
        db.setHost("jdbc:postgresql://localhost:5432");
        db.setUsername("postgres");
        db.setPassword("underfan111");
        db.setDbName("airport-management-system");

        System.out.println(db.getConnection());
    }
}