package me.ams.menu.options.passenger;

import me.ams.controllers.PassengerController;
import me.ams.controllers.interfaces.IPassengerController;
import me.ams.menu.MenuOption;

import java.util.Scanner;

public class ShowPassengerInfoByIdMenuOption implements MenuOption {
    public IPassengerController passengerController;

    public ShowPassengerInfoByIdMenuOption(IPassengerController passengerController) {
        this.passengerController = passengerController;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println(passengerController.getPassengerById(id));

        scanner.close();
    }
}
