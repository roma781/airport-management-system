package me.ams.controllers.interfaces;

public interface IPassengerController {
    String createPassenger(String name, int age, String gender, String isVip);
    String editPassengerById(int id, String name, int age, String gender, String isVip);
    String deletePassengerById(int id);
    String getPassengerById(int id);
    String getAllPassengers();
}