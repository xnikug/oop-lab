package oop.advanced.task1;

import oop.advanced.coffee_specification.Americano;
import oop.advanced.coffee_specification.Cappuccino;
import oop.advanced.coffee_specification.Coffee;
import oop.advanced.coffee_specification.PumpkinSpiceLatte;
import oop.advanced.coffee_specification.SyrupCappuccino;
import oop.advanced.coffee_specification.Intensity;
import oop.advanced.coffee_specification.SyrupType;
public class Main1 {
    public static void main(String[] args) {
        Coffee basicCoffee = new Coffee(Intensity.LIGHT);
        System.out.println("Coffee created with intensity: " + basicCoffee.getIntensityOfCoffee());

        Cappuccino cappuccino = new Cappuccino(Intensity.NORMAL, 50);
        System.out.println("Cappuccino created with intensity: " + cappuccino.getIntensityOfCoffee() + 
                           " and milk: " + cappuccino.getMlOfMilk() + " mg");

        Americano americano = new Americano(Intensity.STRONG, 200);
        System.out.println("Americano created with intensity: " + americano.getIntensityOfCoffee() + 
                           " and water: " + americano.getMlOfWater() + " ml");

        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.NORMAL, 40, 15);
        System.out.println("Pumpkin Spice Latte created with intensity: " + pumpkinSpiceLatte.getIntensityOfCoffee() + 
                           ", milk: " + pumpkinSpiceLatte.getMlOfMilk() + " mg, and pumpkin spice: " + 
                           pumpkinSpiceLatte.getMgOfPumpkinSpice() + " mg");

        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.STRONG, 60, SyrupType.VANILLA);
        System.out.println("Syrup Cappuccino created with intensity: " + syrupCappuccino.getIntensityOfCoffee() + 
                           ", milk: " + syrupCappuccino.getMlOfMilk() + " mg, and syrup: " + syrupCappuccino.getSyrupType());
    }
}
