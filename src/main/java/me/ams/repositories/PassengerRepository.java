package me.ams.repositories;

import me.ams.database.PostgreSQL;
import me.ams.models.Passenger;
import me.ams.repositories.interfaces.IPassengerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengerRepository implements IPassengerRepository {
    @Override
    public boolean createPassenger(Passenger passenger) {
        Connection connection = PostgreSQL.getInstance().getConnection();

        String query = "INSERT INTO passengers (name, age, gender) VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, passenger.getName());
            statement.setInt(2, passenger.getAge());
            statement.setBoolean(3, passenger.getGender());

            statement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Unable to create passenger: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean editPassengerById(int id, Passenger passenger) {
        Connection connection = PostgreSQL.getInstance().getConnection();

        String query = "UPDATE passengers SET (name, age, gender, flight_id, individual_ticket_price) VALUES (?, ?, ?, ?, ?) WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, passenger.getName());
            statement.setInt(2, passenger.getAge());
            statement.setBoolean(3, passenger.getGender());
            statement.setInt(4, passenger.getFlightId());
            statement.setFloat(5, passenger.getIndividualTicketPrice());
            statement.setFloat(6, passenger.getId());

            statement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Unable to edit passenger: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean deletePassengerById(int id) {
        Connection connection = PostgreSQL.getInstance().getConnection();

        String query = "DELETE FROM passengers WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            statement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Unable to delete passenger: " + e.getMessage());
        }
        return false;
    }

    @Override
    public Passenger getPassengerById(int id) {
        Connection connection = PostgreSQL.getInstance().getConnection();

        String query = "SELECT * FROM passengers WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Passenger(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getBoolean("gender"),
                        resultSet.getInt("flight_id"),
                        resultSet.getFloat("individual_ticket_price")
                );
            }
        }
        catch (SQLException e) {
            System.out.println("Passenger not found: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<Passenger> getAllPassengers() {
        List<Passenger> passengers = new ArrayList<>();

        Connection connection = PostgreSQL.getInstance().getConnection();

        String query = "SELECT * FROM passengers";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                passengers.add(new Passenger(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getBoolean("gender"),
                        resultSet.getInt("flight_id"),
                        resultSet.getFloat("individual_ticket_price")
                ));
            }

            return passengers;
        }
        catch (SQLException e) {
            System.out.println("Unable to get all passengers: " + e.getMessage());
        }

        return null;
    }
}
