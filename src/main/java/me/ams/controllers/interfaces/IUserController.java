package me.ams.controllers.interfaces;

import me.ams.models.User;

import java.util.List;

public interface IUserController {
    String createUser(String username, String password);
    String getUserById(int id);
    String getUserByUsername(String username);
    List<User> getAllUsers();
}
