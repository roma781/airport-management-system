package me.ams.menu.options.passenger;

import me.ams.controllers.PassengerController;
import me.ams.controllers.interfaces.IPassengerController;
import me.ams.menu.MenuOption;

public class ImportPassengersFromFileMenuOption implements MenuOption {
    public IPassengerController passengerController;

    public ImportPassengersFromFileMenuOption(IPassengerController passengerController) {
        this.passengerController = passengerController;
    }

    @Override
    public void execute() {
        // TODO: Implement
    }
}
