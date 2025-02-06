package me.ams.repositories;

import me.ams.database.Database;
import me.ams.models.Flight;
import me.ams.models.Passenger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightRepository {
    private PassengerRepository passengerRepository;

    public FlightRepository(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public boolean createFlight(Flight flight) {
        Connection connection = Database.getInstance().getConnection();
        String query = "INSERT INTO flights (airplane, destination, passenger_ids) VALUES (?, ?, ?)";
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
    public Flight getFlightById(int id) {
        Connection connection = Database.getInstance().getConnection();

        String query = "SELECT * FROM flights WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Flight(
                        resultSet.getInt("id"),
                        resultSet.getString("airplane"),
                        resultSet.getString("destination"),
                        (Integer[]) resultSet.getArray("passenger_ids").getArray()
                );
            }
        }
        catch (SQLException e) {
            System.out.println("Passenger not found: " + e.getMessage());
        }

        return null;
    }

    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();

        Connection connection = Database.getInstance().getConnection();

        String query = "SELECT * FROM flights";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                flights.add(new Flight(
                        resultSet.getInt("id"),
                        resultSet.getString("airplane"),
                        resultSet.getString("destination"),
                        (Integer[]) resultSet.getArray("passenger_ids").getArray()
                ));
            }

            return flights;
        }
        catch (SQLException e) {
            System.out.println("Unable to get all flights: " + e.getMessage());
        }

        return null;
    }

    public List<Passenger> getFlightPassengers(int id) {
        List<Passenger> passengers = new ArrayList<>();

        Connection connection = Database.getInstance().getConnection();

        String query = "SELECT passenger_ids FROM flights WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            System.out.println(resultSet);

            if (resultSet.next()) {
                System.out.println();
                for (Integer i : (Integer[]) resultSet.getArray("passenger_ids").getArray()) {
                    System.out.println(passengerRepository.getPassengerById(i));
                    passengers.add(passengerRepository.getPassengerById(i));
                }
            }
        }
        catch (SQLException e) {
            System.out.println("Passengers of this flight are not found: " + e.getMessage());
        }

        return null;
    }
}
