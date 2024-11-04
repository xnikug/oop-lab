package oop.advanced.coffee_specification;

public class Coffee {
    protected Intensity intensityOfCoffee;
    protected final String name = "Coffee";

    public Coffee(Intensity intensityOfCoffee) {
        this.intensityOfCoffee = intensityOfCoffee;
    }
    
    public Coffee(){
        
    }

    public Intensity getIntensityOfCoffee() {
        return intensityOfCoffee;
    }
    protected void setIntensityOfCoffee(Intensity intensityOfCoffee) {
        this.intensityOfCoffee = intensityOfCoffee;
    }

    public String getName() {
        return name;
    }

    public void printDetails() {
        System.out.println("Coffee intensity: " + intensityOfCoffee);
    }
    
    public final void prepareCoffee(Intensity intensityOfCoffee) {
        this.setIntensityOfCoffee(intensityOfCoffee);
        System.out.println("Preparing coffee with intensity: " + intensityOfCoffee);
    }
}
