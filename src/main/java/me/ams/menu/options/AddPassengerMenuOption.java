package me.ams.menu.options;

import me.ams.controllers.PassengerController;
import me.ams.menu.MenuOption;

import java.util.Scanner;

public class AddPassengerMenuOption implements MenuOption {
    public PassengerController passengerController;

    public AddPassengerMenuOption(PassengerController passengerController) {
        this.passengerController = passengerController;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine();

        System.out.print("Enter passenger gender (male/female): ");
        String gender = scanner.nextLine();

        System.out.println(passengerController.createPassenger(name, gender));

        scanner.close();
    }
}
