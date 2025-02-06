package me.ams.models;

public class Passenger {
    private int id;
    private String name;
    private int age;
    private boolean gender;
    private int flightId;
    private float individualTicketPrice;

    public Passenger() {}

    public Passenger(String name, int age, boolean gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Passenger(int id, String name, int age, boolean gender) {
        this(name, age, gender);
        this.id = id;
    }

    public Passenger(int id, String name, int age, boolean gender, int flightId, float individualTicketPrice) {
        this(id, name, age, gender);
        this.flightId = flightId;
        this.individualTicketPrice = individualTicketPrice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public float getIndividualTicketPrice() {
        return individualTicketPrice;
    }

    public void setIndividualTicketPrice(float individualTicketPrice) {
        this.individualTicketPrice = individualTicketPrice;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                '}';
    }
}
