package oop.advanced.coffee_specification;

public class Cappuccino extends Coffee {
    private int mlOfMilk;
    protected final String name = "Cappuccino";

    public Cappuccino(Intensity intensityOfCoffee, int mlOfMilk) {
        super(intensityOfCoffee);
        this.mlOfMilk = mlOfMilk;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public void printDetails() {
        // Reuse from Coffee
        super.printDetails();
        System.out.println(name + " milk: " + mlOfMilk + " mg");
    }
}

