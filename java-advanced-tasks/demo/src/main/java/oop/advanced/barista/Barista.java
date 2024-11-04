package oop.advanced.barista;
import java.util.ArrayList;
import java.util.List;

import oop.advanced.coffee_specification.Americano;
import oop.advanced.coffee_specification.Cappuccino;
import oop.advanced.coffee_specification.Coffee;
import oop.advanced.coffee_specification.Intensity;
import oop.advanced.coffee_specification.PumpkinSpiceLatte;
import oop.advanced.coffee_specification.SyrupCappuccino;
import oop.advanced.coffee_specification.SyrupType;

public class Barista {
    private List<Coffee> orders = new ArrayList<>();

    public void orderCappuccino(Intensity intensity, int mlOfMilk) {
        Cappuccino cappuccino = Cappuccino.makeCappuccino(intensity, mlOfMilk);
        cappuccino.printDetails();
        orders.add(cappuccino);
    }

    public void orderAmericano(Intensity intensity, int mlOfWater) {
        Americano americano = Americano.makeAmericano(intensity, mlOfWater);
        americano.printDetails();
        orders.add(americano);
    }

    public void orderPumpkinSpiceLatte(Intensity intensity, int mlOfMilk, int mgOfPumpkinSpice) {
        PumpkinSpiceLatte pumpkinSpiceLatte = PumpkinSpiceLatte.makePumpkinSpiceLatte(intensity, mlOfMilk, mgOfPumpkinSpice);
        pumpkinSpiceLatte.printDetails();
        orders.add(pumpkinSpiceLatte);
    }
    public void orderSyrupCappuccino(Intensity intensity, int mlOfMilk, SyrupType syrupType) {
        SyrupCappuccino syrupCappuccino = SyrupCappuccino.makeSyrupCappuccino(intensity, mlOfMilk, syrupType);
        syrupCappuccino.printDetails();
        orders.add(syrupCappuccino);
    }

    public void showAllOrders() {
        System.out.println("All Coffee Orders:");
        for (Coffee coffee : orders) {
            coffee.printDetails();
        }
    }
}
