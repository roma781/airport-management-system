package me.ams.menu.menus;

import me.ams.menu.Menu;
import me.ams.menu.options.MenuOption;
import me.ams.menu.options.auth.LoginMenuOption;
import me.ams.menu.options.auth.RegisterMenuOption;
import me.ams.repositories.interfaces.IUserRepository;

import java.util.Scanner;

public class AuthenticationMenu implements Menu {
    private IUserRepository repository;

    private Menu adminMenu;
    private Menu userMenu;

    public AuthenticationMenu(IUserRepository repository, Menu adminMenu, Menu userMenu) {
        this.repository = repository;
        this.adminMenu = adminMenu; this.userMenu = userMenu;
    }

    @Override
    public void startListeningForOptions() {
        showOptions();

        Scanner scanner = new Scanner(System.in);

        int optionNumber = scanner.nextInt();

        if (getOptionFromNumber(optionNumber) != null) {
            executeOption(getOptionFromNumber(optionNumber));
        }
        else {
            System.out.println("Please enter an option!");
        }
    }

    private void showOptions() {
        System.out.println("\nPlease login or register before using the system.\n" +
                "1. Login\n" +
                "2. Register\n"
        );
    }

    @Override
    public MenuOption getOptionFromNumber(int number) {
        return switch (number) {
            case 1 -> new LoginMenuOption(repository, adminMenu, userMenu);
            case 2 -> new RegisterMenuOption(repository);
            default -> null;
        };
    }
}
