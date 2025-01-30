package me.ams;

import me.ams.controllers.PassengerController;
import me.ams.database.Database;
import me.ams.menu.Menu;
import me.ams.repositories.PassengerRepository;

public class AirportManagementSystem {
    public static void main(String[] args) {
        Database.getInstance().setHost("jdbc:postgresql://localhost:5432");
        Database.getInstance().setUsername("postgres");
        Database.getInstance().setPassword("underfan111");
        Database.getInstance().setDbName("airport-management-system");

        PassengerRepository passengerRepository = new PassengerRepository();
        PassengerController passengerController = new PassengerController(passengerRepository);

        Menu menu = new Menu(passengerController);
        menu.startListeningForOptions();
    }
}