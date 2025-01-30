package me.ams.menu;

import me.ams.controllers.PassengerController;
import me.ams.menu.options.AddPassengerMenuOption;
import me.ams.menu.options.ListPassengersMenuOption;
import me.ams.menu.options.ShowPassengerInfoByIdMenuOption;

import java.util.Scanner;

public class Menu {
    private PassengerController passengerController;

    public Menu(PassengerController passengerController) {
        this.passengerController = passengerController;
    }

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

    public void executeOption(MenuOption option) {
        option.execute();
    }

    private void showOptions() {
        System.out.println("\n=== Airport Management System ===\n" +
                "1. Add passenger\n" +
                "2. List passengers\n" +
                "3. Get passenger information by ID\n" +
                "4. Import passengers from file\n" +
                "5. Exit\n");
    }

    private MenuOption getOptionFromNumber(int number) {
        return switch (number) {
            case 1 -> new AddPassengerMenuOption(passengerController);
            case 2 -> new ListPassengersMenuOption(passengerController);
            case 3 -> new ShowPassengerInfoByIdMenuOption(passengerController);
            default -> null;
        };
    }
}
