package oop.advanced.coffee_specification_protected;

import oop.advanced.coffe_enums.Intensity;

public class Cappuccino extends Coffee {
    private int mlOfMilk;
    protected final String name = "Cappuccino";

    protected Cappuccino(Intensity intensityOfCoffee, int mlOfMilk) {
        super(intensityOfCoffee);
        this.mlOfMilk = mlOfMilk;
    }

    protected Cappuccino(){
        
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }
    
    protected void setMlOfMilk(int mlOfMilk) {
        this.mlOfMilk = mlOfMilk;
    }
    @Override
    public void printDetails() {
        // Reuse from Coffee
        super.printDetails();
        System.out.println(name + " milk: " + mlOfMilk + " mg");
    }

    public static Cappuccino makeCappuccino(Intensity intensity, int mlOfMilk) {
        Cappuccino cappuccino = new Cappuccino();
        cappuccino.prepareCoffee(intensity);
        cappuccino.setMlOfMilk(mlOfMilk);
        System.out.println("Adding " + mlOfMilk + " mg of milk");
        System.out.println("Cappuccino is ready!");
        return cappuccino;
    }
}

