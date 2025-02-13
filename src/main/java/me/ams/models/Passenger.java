package me.ams.models;

public class Passenger {
    private int id;
    private String name;
    private int age;
    private boolean gender;
    private boolean isVip;
    private int discount;

    public Passenger() {}

    public Passenger(String name, int age, boolean gender, boolean isVip, int discount) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.isVip = isVip;
        this.discount = discount;
    }

    public Passenger(int id, String name, int age, boolean gender, boolean isVip, int discount) {
        this(name, age, gender, isVip, discount);
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
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
