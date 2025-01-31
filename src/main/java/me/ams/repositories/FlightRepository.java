package me.ams.repositories;

import me.ams.database.Database;
import me.ams.models.Flight;

import java.sql.Connection;

public class FlightRepository {
    public boolean createFlight(Flight flight) {
        Connection connect = Database.getInstance().getConnection();
        String query = "INSERT INTO flights (airplane, destination, passengerIds) VALUES (?, ?, ?)";

    }
}
