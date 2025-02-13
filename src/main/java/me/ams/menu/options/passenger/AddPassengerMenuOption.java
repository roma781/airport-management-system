package me.ams.menu.options.passenger;

import me.ams.controllers.PassengerController;
import me.ams.controllers.interfaces.IPassengerController;
import me.ams.menu.MenuOption;

import java.util.Scanner;

public class AddPassengerMenuOption implements MenuOption {
    public IPassengerController passengerController;

    public AddPassengerMenuOption(IPassengerController passengerController) {
        this.passengerController = passengerController;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter passengers name: ");
        String name = scanner.nextLine();

        System.out.print("Enter passengers gender (male/female): ");
        String gender = scanner.nextLine();

        System.out.print("Enter passengers age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println(passengerController.createPassenger(name, age, gender));

        scanner.close();
    }
}
