package oop.master.services;

// GasStation class
public class GasStation implements Refuelable {
    private int gasCarCount = 0;

    @Override
    public void refuel(String carId) {
        gasCarCount++;
        System.out.println("Refueling gas car " + carId + ".");
    }

    public int getGasCarCount() {
        return gasCarCount;
    }
}