package me.ams.menu.options;

import me.ams.controllers.PassengerController;
import me.ams.menu.MenuOption;

public class ImportPassengersFromFileMenuOption implements MenuOption {
    public PassengerController passengerController;

    public ImportPassengersFromFileMenuOption(PassengerController passengerController) {
        this.passengerController = passengerController;
    }

    @Override
    public void execute() {
        // TODO: Implement
    }
}
