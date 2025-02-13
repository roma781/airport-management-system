package me.ams.menu.options.auth;

import me.ams.controllers.interfaces.IUserController;
import me.ams.menu.Menu;
import me.ams.menu.options.MenuOption;
import me.ams.models.User;
import me.ams.repositories.interfaces.IUserRepository;

import java.util.Objects;
import java.util.Scanner;

public class LoginMenuOption implements MenuOption {
    private IUserRepository userRepository;

    private Menu adminMenu;
    private Menu userMenu;

    public LoginMenuOption(IUserRepository userRepository, Menu adminMenu, Menu userMenu) {
        this.userRepository = userRepository;
        this.adminMenu = adminMenu; this.userMenu = userMenu;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = userRepository.getUserByUsername(username);

        if (user == null) {
            System.out.println("This user doest not exist!");
            return;
        }

        if (!Objects.equals(user.getPassword(), password)) {
            System.out.println("Incorrect password!");
            return;
        }

        if (user.isAdmin()) {
            adminMenu.startListeningForOptions();
        }
        else {
            userMenu.startListeningForOptions();
        }
    }
}
