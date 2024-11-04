package oop.advanced.coffee_specification_protected;

import oop.advanced.coffe_enums.Intensity;
import oop.advanced.coffe_enums.SyrupType;

public class SyrupCappuccino extends Coffee {
    private int mlOfMilk;
    private SyrupType syrupType;
    protected final String name = "SyrupCappuccino";

    protected SyrupCappuccino(Intensity intensityOfCoffee, int mlOfMilk, SyrupType syrupType) {
        super(intensityOfCoffee);
        this.mlOfMilk = mlOfMilk;
        this.syrupType = syrupType;
    }

    protected SyrupCappuccino() {

    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }
    protected void setMlOfMilk(int mlOfMilk) {
        this.mlOfMilk = mlOfMilk;
    }


    public SyrupType getSyrupType() {
        return syrupType;
    }
    protected void setSyrupType(SyrupType syrupType) {
        this.syrupType = syrupType;
    }

    @Override
    public void printDetails() {
        // Reuse from Coffee
        super.printDetails();
        System.out.println(name + " milk: " + mlOfMilk + " mg");
        System.out.println(name + " syrup type: " + syrupType);
    }

    public static SyrupCappuccino makeSyrupCappuccino(Intensity intensityOfCoffee, int mlOfMilk, SyrupType syrupType) {
        SyrupCappuccino syrupCappuccino = new SyrupCappuccino();
        syrupCappuccino.prepareCoffee(intensityOfCoffee);
        syrupCappuccino.setMlOfMilk(mlOfMilk);
        syrupCappuccino.setSyrupType(syrupType);
        System.out.println("Adding " + mlOfMilk + " mg of milk");
        System.out.println("Adding " + syrupType + " syrup");
        System.out.println("Syrup Cappuccino is ready!");
        return syrupCappuccino;
    }
}

