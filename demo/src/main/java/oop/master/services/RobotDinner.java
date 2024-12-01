package oop.master.services;

// RobotDinner class
public class RobotDinner implements Dineable {
    private int robotCount = 0; // Static variable to track the number of robots served

    @Override
    public void serveDinner(String carId) {
        robotCount++;
        System.out.println("Serving dinner to robots in car " + carId + ".");
    }

    // Static method to get the count of robots served
    public int getRobotCount() {
        return robotCount;
    }
}