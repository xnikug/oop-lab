package oop.advanced.task3;

import oop.advanced.coffee_specification.Americano;
import oop.advanced.coffee_specification.Cappuccino;
import oop.advanced.coffee_specification.Intensity;
import oop.advanced.coffee_specification.PumpkinSpiceLatte;
import oop.advanced.coffee_specification.SyrupCappuccino;
import oop.advanced.coffee_specification.SyrupType;

public class Main3 {
    public static void main(String[] args) {
        System.out.println("Making a Cappuccino:");
        @SuppressWarnings("unused")
        Cappuccino cappuccino = Cappuccino.makeCappuccino(Intensity.NORMAL, 50);
        System.out.println();

        System.out.println("Making a Pumpkin Spice Latte:");
        @SuppressWarnings("unused")
        PumpkinSpiceLatte pumpkinSpiceLatte = PumpkinSpiceLatte.makePumpkinSpiceLatte(Intensity.STRONG, 60, 20);
        System.out.println();

        System.out.println("Making an Americano:");
        @SuppressWarnings("unused")
        Americano americano = Americano.makeAmericano(Intensity.LIGHT, 250);
        System.out.println();

        System.out.println("Making a Syrup Cappuccino:");
        @SuppressWarnings("unused")
        SyrupCappuccino syrupCappuccino = SyrupCappuccino.makeSyrupCappuccino(Intensity.NORMAL, 50, SyrupType.CARAMEL);
    }
}
