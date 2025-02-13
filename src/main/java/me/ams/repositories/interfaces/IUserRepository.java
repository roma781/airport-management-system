package me.ams.repositories.interfaces;

import me.ams.models.User;

import java.util.List;

public interface IUserRepository {
    boolean registerUser(User user);
    User getUserById(int id);
    User getUserByUsername(String username);
    List<User> getAllUsers();
}
