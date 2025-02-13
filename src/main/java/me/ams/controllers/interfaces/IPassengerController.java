package me.ams.controllers.interfaces;

public interface IPassengerController {
    String createPassenger(String name, int age, String gender);
    String editPassengerById(int id, String name, int age, String gender, int flightId, int individual_ticket_price);
    String deletePassengerById(int id);
    String getPassengerById(int id);
    String getAllPassengers();
}
