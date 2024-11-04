package oop.advanced.coffee_specification;

public class Coffee {
    protected Intensity intensityOfCoffee;
    protected final String name = "Coffee";

    public Coffee(Intensity intensityOfCoffee) {
        this.intensityOfCoffee = intensityOfCoffee;
    }

    public Intensity getIntensityOfCoffee() {
        return intensityOfCoffee;
    }

    public String getName() {
        return name;
    }
    
    public void printDetails() {
        System.out.println("Coffee intensity: " + intensityOfCoffee);
    }
}
