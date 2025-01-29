package me.ams.models;

public class Passenger {
    private int id;
    private String name;
    private boolean gender;

    public Passenger() {}
    public Passenger(String name, boolean gender) {
        this.name = name;
        this.gender = gender;
    }
    public Passenger(int id, String name, boolean gender) {
        this(name, gender);
        this.id = id;
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
}
