package me.ams.menu.menus;

import me.ams.controllers.interfaces.IFlightController;
import me.ams.controllers.interfaces.IPassengerController;
import me.ams.menu.Menu;
import me.ams.menu.options.MenuOption;
import me.ams.menu.options.flight.CreateFlightMenuOption;
import me.ams.menu.options.flight.ListFlightsMenuOption;
import me.ams.menu.options.passenger.AddPassengerMenuOption;
import me.ams.menu.options.passenger.ImportPassengersFromFileMenuOption;
import me.ams.menu.options.passenger.ListPassengersMenuOption;
import me.ams.menu.options.passenger.ShowPassengerInfoByIdMenuOption;

import java.util.Scanner;

public class AdminMenu implements Menu {
    private IPassengerController passengerController;
    private IFlightController flightController;

    public AdminMenu(IPassengerController passengerController, IFlightController flightController) {
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
        System.out.println("\n=== Airport Management System (ADMIN MODE) ===\n" +
                "1. Add passenger\n" +
                "2. List passengers\n" +
                "3. Get passenger information by ID\n" +
                "4. Import passengers from file (not yet implemented)\n" +
                "----------------------------------------------------\n" +
                "5. Create flight\n" +
                "6. List flights\n" +
                "7. Get flight information by ID\n");
    }

    @Override
    public MenuOption getOptionFromNumber(int number) {
        return switch (number) {
            case 1 -> new AddPassengerMenuOption(passengerController);
            case 2 -> new ListPassengersMenuOption(passengerController);
            case 3 -> new ShowPassengerInfoByIdMenuOption(passengerController);
            case 4 -> new ImportPassengersFromFileMenuOption(passengerController);
            case 5 -> new CreateFlightMenuOption(flightController, passengerController);
            case 6 -> new ListFlightsMenuOption(flightController);
            default -> null;
        };
    }
}
