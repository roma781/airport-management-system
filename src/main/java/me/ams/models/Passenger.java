package me.ams.models;

public class Passenger {
    private int id;
    private String name;
    private String gender;

    public Passenger() {}
    public Passenger(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }
    public Passenger(int id, String name, String gender) {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
