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
    public String createPassenger(String name, int age, String gender) {
        boolean bGender = gender.equalsIgnoreCase("male");

        boolean created = repository.createPassenger(new Passenger(name, age, bGender));
        return created ? "Passenger was created: " : "Passenger creation failed";
    }

    @Override
    public String editPassengerById(int id, String name, int age, String gender, int flightId, int individual_ticket_price) {
        boolean bGender = gender.equalsIgnoreCase("male");
        boolean edited = repository.editPassengerById(id, new Passenger(name, age, bGender, flightId, individual_ticket_price));
        return edited ? "Passenger was edited" : "An error occured when tried to edit a passenger";
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
