package oop.advanced.coffee_specification;

public class Americano extends Coffee {
    private int mlOfWater;
    protected final String name = "Americano";

    public Americano(Intensity intensityOfCoffee, int mlOfWater) {
        super(intensityOfCoffee);
        this.mlOfWater = mlOfWater;
    }

    public int getMlOfWater() {
        return mlOfWater;
    }

    @Override
    public String getName() {
        return name;
    }
}

