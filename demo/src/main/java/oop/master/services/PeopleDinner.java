package oop.master.services;

// PeopleDinner class
public class PeopleDinner implements Dineable {
    private int peopleCount = 0; // Static variable to track the number of people served

    @Override
    public void serveDinner(String carId) {
        peopleCount++;
        System.out.println("Serving dinner to people in car " + carId + ".");
    }

    // Static method to get the count of people served
    public int getPeopleCount() {
        return peopleCount;
    }
}
