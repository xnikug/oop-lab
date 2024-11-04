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
    public SyrupCappuccino() {
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }
    public void setMlOfMilk(int mlOfMilk) {
        this.mlOfMilk = mlOfMilk;
    }


    public SyrupType getSyrupType() {
        return syrupType;
    }
    public void setSyrupType(SyrupType syrupType) {
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

