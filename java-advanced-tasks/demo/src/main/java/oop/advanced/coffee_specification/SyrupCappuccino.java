package oop.advanced.coffee_specification;

public class SyrupCappuccino extends Coffee {
    private int mlOfMilk;
    private SyrupType syrupType;
    protected final String name = "SyrupCappuccino";

    public SyrupCappuccino(Intensity intensityOfCoffee, int mlOfMilk, SyrupType syrupType) {
        super(intensityOfCoffee);
        this.mlOfMilk = mlOfMilk;
        this.syrupType = syrupType;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    public SyrupType getSyrupType() {
        return syrupType;
    }

    @Override
    public String getName() {
        return name;
    }
}

