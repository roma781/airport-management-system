package me.ams.menu;

import me.ams.controllers.FlightController;
import me.ams.controllers.PassengerController;
import me.ams.menu.options.*;

import java.util.Scanner;

public class Menu {
    private PassengerController passengerController;
    private FlightController flightController;

    public Menu(PassengerController passengerController, FlightController flightController) {
        this.passengerController = passengerController;
        this.flightController = flightController;
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
                "4. Import passengers from file (not yet implemented)\n" +
                "----------------------------------------------------\n" +
                "5. Create flight\n" +
                "6. List flights\n" +
                "7. Get flight information by ID\n");
    }

    private MenuOption getOptionFromNumber(int number) {
        return switch (number) {
            case 1 -> new AddPassengerMenuOption(passengerController);
            case 2 -> new ListPassengersMenuOption(passengerController);
            case 3 -> new ShowPassengerInfoByIdMenuOption(passengerController);
            case 4 -> new ImportPassengersFromFileMenuOption(passengerController);
            case 5 -> new CreateFlightMenuOption(flightController, passengerController);
            default -> null;
        };
    }
}
