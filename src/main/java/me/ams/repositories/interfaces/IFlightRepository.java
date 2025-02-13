package me.ams.repositories.interfaces;

import me.ams.models.Flight;
import me.ams.models.Passenger;

import java.util.List;

public interface IFlightRepository {
    boolean createFlight(Flight flight);
    boolean deleteFlight(int id);
    Flight getFlightById(int id);
    List<Flight> getAllFlights();
    List<Passenger> getFlightPassengers(int id);
}
