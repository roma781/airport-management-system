package me.ams.menu.menus;

import me.ams.controllers.interfaces.IFlightController;
import me.ams.controllers.interfaces.IPassengerController;
import me.ams.menu.Menu;
import me.ams.menu.options.MenuOption;
import me.ams.menu.options.flight.ListFlightsMenuOption;
import me.ams.menu.options.passenger.ListPassengersMenuOption;
import me.ams.menu.options.passenger.ShowPassengerInfoByIdMenuOption;

import java.util.Scanner;

public class UserMenu implements Menu {
    private IPassengerController passengerController;
    private IFlightController flightController;

    public UserMenu(IPassengerController passengerController, IFlightController flightController) {
        this.passengerController = passengerController;
        this.flightController = flightController;
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
        System.out.println("\n=== Airport Management System ===\n" +
                "1. List passengers\n" +
                "2. Get passenger information by ID\n" +
                "----------------------------------------------------\n" +
                "3. List flights\n" +
                "4. Get flight information by ID\n");
    }

    @Override
    public MenuOption getOptionFromNumber(int number) {
        return switch (number) {
            case 1 -> new ListPassengersMenuOption(passengerController);
            case 2 -> new ShowPassengerInfoByIdMenuOption(passengerController);
            case 3 -> new ListFlightsMenuOption(flightController);
            default -> null;
        };
    }
}
