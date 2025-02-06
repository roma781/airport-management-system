package me.ams;

import me.ams.controllers.FlightController;
import me.ams.controllers.PassengerController;
import me.ams.database.Database;
import me.ams.menu.Menu;
import me.ams.repositories.FlightRepository;
import me.ams.repositories.PassengerRepository;

public class AirportManagementSystem {
    public static void main(String[] args) {
        Database.getInstance().setHost("jdbc:postgresql://localhost:5432");
        Database.getInstance().setUsername("postgres");
        Database.getInstance().setPassword("underfan111");
        Database.getInstance().setDbName("airport-management-system");

        PassengerRepository passengerRepository = new PassengerRepository();
        PassengerController passengerController = new PassengerController(passengerRepository);

        FlightRepository flightRepository = new FlightRepository(passengerRepository);
        FlightController flightController = new FlightController(flightRepository);

        Menu menu = new Menu(passengerController, flightController);
        menu.startListeningForOptions();
    }
}