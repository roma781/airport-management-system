package me.ams.menu.options.flight;

import me.ams.controllers.FlightController;
import me.ams.controllers.PassengerController;
import me.ams.controllers.interfaces.IFlightController;
import me.ams.controllers.interfaces.IPassengerController;
import me.ams.menu.MenuOption;

import java.util.*;

public class CreateFlightMenuOption implements MenuOption {
    private IFlightController flightController;
    private IPassengerController passengerController;

    public CreateFlightMenuOption(IFlightController flightController, IPassengerController passengerController) {
        this.flightController = flightController;
        this.passengerController = passengerController;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter airplane: ");
        String airplane = scanner.nextLine();

        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();


        // The code below is a radiation hazard, fix and rewrite before endterm
        System.out.print("Enter passenger IDs (to stop type 'end'): ");
        List<Integer> ids = new ArrayList<>();

        while (!Objects.equals(scanner.nextLine(), "end")) {
            ids.add(Integer.parseInt(scanner.nextLine()));
        }

        flightController.createFlight(airplane, destination, ids.toArray(new Integer[0]));

        scanner.close();
    }
}
