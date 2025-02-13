package me.ams.controllers;

import me.ams.controllers.interfaces.IUserController;
import me.ams.models.Passenger;
import me.ams.models.User;
import me.ams.repositories.interfaces.IUserRepository;

import java.util.List;

public class UserController implements IUserController {
    private IUserRepository repository;

    public UserController(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public String createUser(String username, String password) {
        boolean created = repository.registerUser(new User(username, password, false));
        return created
                ? "Successfully created user with these parameters: " + username + ", " + password + ", Admin = false"
                : "Error creating user.";
    }

    @Override
    public String getUserById(int id) {
        return "";
    }

    @Override
    public String getUserByUsername(String username) {
        User user = repository.getUserByUsername(username);
        return user == null ? "Passenger does not exist" : user.toString();
    }

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }
}
