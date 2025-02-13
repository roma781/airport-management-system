package me.ams.controllers.interfaces;

public interface IFlightController {
    String createFlight(String airplane, String destination, float ticketPrice, Integer[] passengerIds);
    String deleteFlight(int id);
    String getAllFlights();

}
