package oop.advanced.coffee_specification;

public class PumpkinSpiceLatte extends Coffee {
    private int mlOfMilk;
    private int mgOfPumpkinSpice;
    protected final String name = "PumpkinSpiceLatte";

    public PumpkinSpiceLatte(Intensity intensityOfCoffee, int mlOfMilk, int mgOfPumpkinSpice) {
        super(intensityOfCoffee);
        this.mlOfMilk = mlOfMilk;
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    public int getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
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
        System.out.println(name + " pumpkin spice: " + mgOfPumpkinSpice + " mg");
    }
}
