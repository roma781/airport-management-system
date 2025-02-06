package me.ams.repositories;

import me.ams.database.Database;
import me.ams.models.Flight;

import java.sql.Connection;

public class FlightRepository {
    public boolean createFlight(Flight flight) {
        Connection connect = Database.getInstance().getConnection();
        String query = "INSERT INTO flights (airplane, destination, passengerIds) VALUES (?, ?, ?)";
        try{

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, flight.getAirplane());
            statement.setString(2, flight.getDestination());
            statement.setArray(3, connection.createArrayOf("INTEGER", flight.getPassengerIds()));

            statement.execute();
            return true;
        }
        catch (SQLException e) {
            System.out.println("Unable to create flight: " + e.getMessage());
        }
        return false;
    }
    public boolean deleteFlight(int id) {
        Connection connection = Database.getInstance().getConnection();
        String query = "DELETE FROM flights WHERE id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            statement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Unable to delete flight: " + e.getMessage());
        }
        return false;
    }
}
