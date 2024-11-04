package oop.advanced.task2;

import oop.advanced.coffee_specification.Americano;
import oop.advanced.coffee_specification.Cappuccino;
import oop.advanced.coffee_specification.PumpkinSpiceLatte;
import oop.advanced.coffee_specification.SyrupCappuccino;
import oop.advanced.coffee_specification.Intensity;
import oop.advanced.coffee_specification.SyrupType;
public class Main2 {
    public static void main(String[] args) {
        Cappuccino cappuccino = new Cappuccino(Intensity.NORMAL, 50);
        System.out.println("Cappuccino details:");
        cappuccino.printDetails();
        System.out.println();

        Americano americano = new Americano(Intensity.STRONG, 200);
        System.out.println("Americano details:");
        americano.printDetails();
        System.out.println();

        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.NORMAL, 40, 15);
        System.out.println("Pumpkin Spice Latte details:");
        pumpkinSpiceLatte.printDetails();
        System.out.println();

        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.STRONG, 60, SyrupType.VANILLA);
        System.out.println("Syrup Cappuccino details:");
        syrupCappuccino.printDetails();
    }
}

