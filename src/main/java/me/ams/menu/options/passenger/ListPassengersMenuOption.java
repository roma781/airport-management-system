package me.ams.menu.options.passenger;

import me.ams.controllers.PassengerController;
import me.ams.controllers.interfaces.IPassengerController;
import me.ams.menu.MenuOption;

public class ListPassengersMenuOption implements MenuOption {
    public IPassengerController passengerController;

    public ListPassengersMenuOption(IPassengerController passengerController) {
        this.passengerController = passengerController;
    }

    @Override
    public void execute() {
        System.out.println("Here's all of the passengers that are stored in database:\n" + passengerController.getAllPassengers());
    }
}
