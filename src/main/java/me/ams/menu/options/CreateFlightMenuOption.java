package me.ams.menu.options;

import me.ams.controllers.FlightController;
import me.ams.controllers.PassengerController;
import me.ams.menu.MenuOption;

import java.util.*;

public class CreateFlightMenuOption implements MenuOption {
    private FlightController flightController;
    private PassengerController passengerController;

    public CreateFlightMenuOption(FlightController flightController, PassengerController passengerController) {
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
