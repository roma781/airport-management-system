package me.ams.controllers;

import me.ams.models.Flight;
import me.ams.models.Passenger;
import me.ams.repositories.FlightRepository;

import java.util.List;

public class FlightController {
    private FlightRepository repository;

    public FlightController(FlightRepository repository) {
        this.repository = repository;
    }

    public String createFlight(String airplane, String destination, Integer[] passengerIds) {
        boolean created = repository.createFlight(new Flight(airplane, destination, passengerIds));
        return created ? "Flight was created." : "Error creating flight";
    }

    public String deleteFlight(int id) {
        boolean deleted = repository.deleteFlight(id);
        return deleted ? "Flight with " + id + "was deleted" : "Error deleting flight.";
    }

    public String getAllFlights() {
        List<Flight> flights = repository.getAllFlights();

        StringBuilder response = new StringBuilder();

        for (Flight flight : flights) {
            response.append(flight.toString());

            for (Passenger passenger : repository.getFlightPassengers(flight.getId())) {
                response.append(passenger);
            }
        }

        return response.toString();
    }
}
