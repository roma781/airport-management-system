package me.ams;

import me.ams.controllers.FlightController;
import me.ams.controllers.PassengerController;
import me.ams.controllers.interfaces.IFlightController;
import me.ams.database.PostgreSQL;
import me.ams.menu.Menu;
import me.ams.repositories.FlightRepository;
import me.ams.repositories.PassengerRepository;
import me.ams.repositories.interfaces.IFlightRepository;

public class AirportManagementSystem {
    public static void main(String[] args) {
        PostgreSQL.getInstance().setHost("jdbc:postgresql://localhost:5432");
        PostgreSQL.getInstance().setUsername("postgres");
        PostgreSQL.getInstance().setPassword("underfan111");
        PostgreSQL.getInstance().setDbName("airport-management-system");

        PassengerRepository passengerRepository = new PassengerRepository();
        PassengerController passengerController = new PassengerController(passengerRepository);

        IFlightRepository flightRepository = new FlightRepository(passengerRepository);
        IFlightController flightController = new FlightController(flightRepository);

        Menu menu = new Menu(passengerController, flightController);
        menu.startListeningForOptions();
    }
}