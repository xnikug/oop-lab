package oop.advanced.coffee_specification_protected;

import oop.advanced.coffe_enums.Intensity;

public class PumpkinSpiceLatte extends Coffee {
    private int mlOfMilk;
    private int mgOfPumpkinSpice;
    protected final String name = "PumpkinSpiceLatte";

    protected PumpkinSpiceLatte(Intensity intensityOfCoffee, int mlOfMilk, int mgOfPumpkinSpice) {
        super(intensityOfCoffee);
        this.mlOfMilk = mlOfMilk;
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    protected PumpkinSpiceLatte() {

    }
    public int getMlOfMilk() {
        return mlOfMilk;
    }

    protected void setMlOfMilk(int mlOfMilk) {
        this.mlOfMilk = mlOfMilk;
    }

    public int getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }
    
    protected void setMgOfPumpkinSpice(int mgOfPumpkinSpice) {
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }


    @Override
    public void printDetails() {
        // Reuse from Coffee
        super.printDetails();
        System.out.println(name + " milk: " + mlOfMilk + " mg");
        System.out.println(name + " pumpkin spice: " + mgOfPumpkinSpice + " mg");
    }

    public static PumpkinSpiceLatte makePumpkinSpiceLatte(Intensity intensity, int mlOfMilk, int mgOfPumpkinSpice) {
        PumpkinSpiceLatte latte = new PumpkinSpiceLatte();
        latte.prepareCoffee(intensity);
        latte.setMlOfMilk(mlOfMilk);
        latte.setMgOfPumpkinSpice(mgOfPumpkinSpice);
        System.out.println("Adding " + mlOfMilk + " mg of milk");
        System.out.println("Adding " + mgOfPumpkinSpice + " mg of pumpkin spice");
        System.out.println("Pumpkin Spice Latte is ready!");
        return latte;
    }
}
