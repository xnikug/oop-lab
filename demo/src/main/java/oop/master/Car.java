package oop.master;

import oop.master.enums.CarTypes;

public class Car {

    private Integer id;
    private CarTypes type;
    private String passengers;
    private Boolean isDining;
    private Integer consumption;

    // Constructor
    public Car(Integer id, CarTypes type, String passengers, Boolean isDining, Integer consumption) {
        this.id = id;
        this.type = type;
        this.passengers = passengers;
        this.isDining = isDining;
        this.consumption = consumption;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CarTypes getType() {
        return type;
    }

    public void setType(CarTypes type) {
        this.type = type;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public Boolean isDining() {
        return isDining;
    }

    public void setDining(Boolean dining) {
        isDining = dining;
    }

    public Integer getConsumption() {
        return consumption;
    }

    public void setConsumption(Integer consumption) {
        this.consumption = consumption;
    }
    // Override toString to return JSON format
    @Override
    public String toString() {
        return "{" +
                "\"id\": " + id + ", " +
                "\"type\": \"" + type + "\", " +
                "\"passengers\": \"" + passengers + "\", " +
                "\"isDining\": " + isDining + ", " +
                "\"consumption\": " + consumption +
                "}";
    }
}
