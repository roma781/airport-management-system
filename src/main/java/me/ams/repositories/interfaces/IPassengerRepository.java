package me.ams.repositories.interfaces;

import me.ams.models.Passenger;

import java.util.List;

public interface IPassengerRepository {
    boolean createPassenger(Passenger passenger);
    boolean editPassengerById(int id, Passenger passenger);
    boolean deletePassengerById(int id);
    Passenger getPassengerById(int id);
    List<Passenger> getAllPassengers();
}
