package me.ams.menu.options.auth;

import me.ams.menu.options.MenuOption;
import me.ams.models.User;
import me.ams.repositories.interfaces.IUserRepository;

import java.util.Scanner;

public class RegisterMenuOption implements MenuOption {
    private IUserRepository userRepository;

    public RegisterMenuOption(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the username for your new account: ");
        String username = scanner.nextLine();

        System.out.print("Enter the password for your new account: ");
        String password = scanner.nextLine();

        System.out.println("Creating new account...");
        userRepository.registerUser(new User(username, password, false));
    }
}
