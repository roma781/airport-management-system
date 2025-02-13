package me.ams.controllers.interfaces;

public interface IPassengerController {
    String createPassenger(String name, int age, String gender, boolean isVip, int discount);
    String editPassengerById(int id, String name, int age, String gender, boolean isVip, int discount);
    String deletePassengerById(int id);
    String getPassengerById(int id);
    String getAllPassengers();
}