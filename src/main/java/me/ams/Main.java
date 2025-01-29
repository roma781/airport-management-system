package me.ams;

import me.ams.database.Database;

public class Main {
    public static void main(String[] args) {
        Database.getInstance().setHost("jdbc:postgresql://localhost:5432");
        Database.getInstance().setUsername("postgres");
        Database.getInstance().setPassword("underfan111");
        Database.getInstance().setDbName("airport-management-system");

        System.out.println(Database.getInstance().getConnection());
    }
}