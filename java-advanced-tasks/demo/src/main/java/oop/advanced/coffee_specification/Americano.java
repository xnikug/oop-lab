package oop.advanced.coffee_specification;

public class Americano extends Coffee {
    private int mlOfWater;
    protected final String name = "Americano";

    public Americano(Intensity intensityOfCoffee, int mlOfWater) {
        super(intensityOfCoffee);
        this.mlOfWater = mlOfWater;
    }
    public Americano() {
        
    }
    public int getMlOfWater() {
        return mlOfWater;
    }
    public void setMlOfWater(int mlOfWater) {
        this.mlOfWater = mlOfWater;
    }

    @Override
    public void printDetails() {
        // Reuse from Coffee
        super.printDetails();
        System.out.println(name + " water: " + mlOfWater + " ml");
    }
    public static Americano makAmericano(Intensity intensity, int mlOfWater) {
        Americano americano = new Americano();
        americano.prepareCoffee(intensity);
        americano.setMlOfWater(mlOfWater);
        System.out.println("Adding " + mlOfWater + " ml of water");
        System.out.println("Americano is ready!");
        return americano;
    }
}

