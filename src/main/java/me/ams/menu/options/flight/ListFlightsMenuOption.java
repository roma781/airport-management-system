package me.ams.menu.options.flight;

import me.ams.controllers.interfaces.IFlightController;
import me.ams.menu.options.MenuOption;

public class ListFlightsMenuOption implements MenuOption {
    private IFlightController flightController;

    public ListFlightsMenuOption(IFlightController flightController) {
        this.flightController = flightController;
    }

    @Override
    public void execute() {
        System.out.println(flightController.getAllFlights());
    }
}
