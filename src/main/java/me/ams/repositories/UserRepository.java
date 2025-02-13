package me.ams.repositories;

import me.ams.database.PostgreSQL;
import me.ams.models.User;
import me.ams.repositories.interfaces.IUserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    @Override
    public boolean registerUser(User user) {
        Connection connection = PostgreSQL.getInstance().getConnection();

        String query = "INSERT INTO users (username, password, admin) VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setBoolean(3, user.isAdmin());

            statement.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Unable to create user: " + e.getMessage());
        }
        return false;
    }

    @Override
    public User getUserById(int id) {
        Connection connection = PostgreSQL.getInstance().getConnection();

        String query = "SELECT * FROM users WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("admin")
                );
            }
        }
        catch (SQLException e) {
            System.out.println("User not found: " + e.getMessage());
        }

        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        Connection connection = PostgreSQL.getInstance().getConnection();

        String query = "SELECT * FROM users WHERE username = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("admin")
                );
            }
        }
        catch (SQLException e) {
            System.out.println("User not found: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        Connection connection = PostgreSQL.getInstance().getConnection();

        String query = "SELECT * FROM users";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("admin")
                ));
            }

            return users;
        }
        catch (SQLException e) {
            System.out.println("Unable to get all users: " + e.getMessage());
        }

        return null;
    }
}
