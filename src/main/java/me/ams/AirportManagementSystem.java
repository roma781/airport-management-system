package me.ams;

import me.ams.controllers.FlightController;
import me.ams.controllers.PassengerController;
import me.ams.controllers.UserController;
import me.ams.controllers.interfaces.IFlightController;
import me.ams.controllers.interfaces.IUserController;
import me.ams.database.PostgreSQL;
import me.ams.menu.menus.AdminMenu;
import me.ams.menu.menus.AuthenticationMenu;
import me.ams.menu.menus.UserMenu;
import me.ams.repositories.FlightRepository;
import me.ams.repositories.PassengerRepository;
import me.ams.repositories.UserRepository;
import me.ams.repositories.interfaces.IFlightRepository;
import me.ams.repositories.interfaces.IUserRepository;

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

        IUserRepository userRepository = new UserRepository();

        UserMenu userMenu = new UserMenu(passengerController, flightController);
        AdminMenu adminMenu = new AdminMenu(passengerController, flightController);

        new AuthenticationMenu(userRepository, adminMenu, userMenu).startListeningForOptions();
    }
}