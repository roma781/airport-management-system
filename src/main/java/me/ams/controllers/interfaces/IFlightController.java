package me.ams.controllers.interfaces;

public interface IFlightController {
    String createFlight(String airplane, String destination, Integer[] passengerIds);
    String deleteFlight(int id);
    String getAllFlights();

}
