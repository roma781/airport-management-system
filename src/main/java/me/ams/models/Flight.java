package me.ams.models;


import java.util.Arrays;

public class Flight {
    private int id;
    private String airplane;
    private String destination;
    private float ticketPrice;
    private Integer[] passengerIds;

    public Flight() {}

    public Flight(String airplane, String destination, float ticketPrice, Integer[] passengerIds) {
        this.airplane = airplane;
        this.destination = destination;
        this.ticketPrice = ticketPrice;
        this.passengerIds = passengerIds;
    }

    public Flight(int id, String airplane, String destination, float ticketPrice, Integer[] passengerIds) {
        this(airplane, destination, ticketPrice, passengerIds);
        this.id = id;
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

    public Integer[] getPassengerIds() {
        return passengerIds;
    }

    public void setPassengerIds(Integer[] passengerIds) {
        this.passengerIds = passengerIds;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", airplane='" + airplane + '\'' +
                ", destination='" + destination + '\'' +
                ", passengerIds=" + Arrays.toString(passengerIds) +
                "}\n";
    }
}
