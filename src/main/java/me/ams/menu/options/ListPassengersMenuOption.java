package me.ams.menu.options;

import me.ams.controllers.PassengerController;
import me.ams.menu.MenuOption;

public class ListPassengersMenuOption implements MenuOption {
    public PassengerController passengerController;

    public ListPassengersMenuOption(PassengerController passengerController) {
        this.passengerController = passengerController;
    }

    @Override
    public void execute() {
        System.out.println("Here's all of the passengers that are stored in database:\n" + passengerController.getAllPassengers());
    }
}
