package me.ams.controllers;

import me.ams.controllers.interfaces.IPassengerController;
import me.ams.models.Passenger;
import me.ams.repositories.PassengerRepository;

import java.util.List;

public class PassengerController implements IPassengerController {
    private PassengerRepository repository;

    public PassengerController(PassengerRepository repository) {
        this.repository = repository;
    }

    @Override
    public String createPassenger(String name, int age, String gender, String isVip) {
        boolean bGender = gender.equalsIgnoreCase("male");
        boolean bIsVip = isVip.equalsIgnoreCase("yes");

        int discount = 0;

        if (age < 10 || bIsVip) {
            discount = 50;
        }

        boolean created = repository.createPassenger(new Passenger(name, age, bGender, bIsVip, discount));
        return created
                ? "Passenger was created with these parameters: " + name + ", " + gender + ", VIP = " + isVip
                : "Passenger creation failed";
    }

    @Override
    public String editPassengerById(int id, String name, int age, String gender, String isVip) {
        boolean bGender = gender.equalsIgnoreCase("male");
        boolean bIsVip = gender.equalsIgnoreCase("yes");

        int discount = 0;

        if (age < 10 || bIsVip) {
            discount = 50;
        }

        boolean edited = repository.editPassengerById(id, new Passenger(name, age, bGender, bIsVip, discount));
        return edited
                ? "Passenger was edited with these new parameters: " + name + ", " + gender + ", VIP = " + isVip
                : "An error occured when tried to edit a passenger";
    }

    @Override
    public String deletePassengerById(int id) {
        boolean deleted = repository.deletePassengerById(id);
        return deleted ? "Passenger was deleted" : "An error occured when tried to delete a passenger";
    }

    @Override
    public String getPassengerById(int id) {
        Passenger passenger = repository.getPassengerById(id);
        return passenger == null ? "Passenger does not exist" : passenger.toString();
    }

    @Override
    public String getAllPassengers() {
        List<Passenger> passengers = repository.getAllPassengers();

        StringBuilder response = new StringBuilder();

        for (Passenger passenger : passengers) {
            response.append(passenger).append("\n");
        }

        return response.toString();
    }
}