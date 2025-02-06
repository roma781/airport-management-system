package me.ams.menu.options.flight;

import me.ams.controllers.FlightController;
import me.ams.controllers.PassengerController;
import me.ams.menu.MenuOption;
import me.ams.repositories.FlightRepository;
import me.ams.repositories.PassengerRepository;

public class ListFlightsMenuOption implements MenuOption {
    private FlightController flightController;

    public ListFlightsMenuOption(FlightController flightController) {
        this.flightController = flightController;
    }

    @Override
    public void execute() {
        System.out.println(flightController.getAllFlights());
    }
}
