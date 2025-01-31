package me.ams.models;


import java.util.Arrays;

public class Flight {
    private int id;
    private String airplane;
    private String destination;
    private int[] passengerIds;

    public Flight() {}

    public Flight(String airplane, String destination, int[] passengerIds) {
        this.airplane = airplane;
        this.destination = destination;
        this.passengerIds = passengerIds;
    }

    public Flight(int id, String airplane, String destination, int[] passengerIds) {
        this.id = id;
        this.airplane = airplane;
        this.destination = destination;
        this.passengerIds = passengerIds;
    }

    public int getId() {
        return id;
    }

    public String getAirplane() {
        return airplane;
    }

    public void setAirplane(String airplane) {
        this.airplane = airplane;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int[] getPassengerIds() {
        return passengerIds;
    }

    public void setPassengerIds(int[] passengerIds) {
        this.passengerIds = passengerIds;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", airplane='" + airplane + '\'' +
                ", destination='" + destination + '\'' +
                ", passengerIds=" + Arrays.toString(passengerIds) +
                '}';
    }
}
