package me.ams.controllers;

import me.ams.models.Flight;
import me.ams.repositories.FlightRepository;

public class FlightController {
    private FlightRepository repository;

    public FlightController(FlightRepository repository) {
        this.repository = repository;
    }

    public String createFlight(String airplane, String destination, Integer[] passengerIds) {
        boolean created = repository.createFlight(new Flight(airplane, destination, passengerIds));
        return created ? "Flight was created." : "Error creating flight";
    }
}
