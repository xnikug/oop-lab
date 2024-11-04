package oop.advanced.task4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import oop.advanced.barista.Barista;
import oop.advanced.coffe_enums.Intensity;
public class Main4 {
    public static void main(String[] args) {
        Barista barista = new Barista();

        // Placing orders through Barista
        barista.orderCappuccino(Intensity.NORMAL, 50);
        System.out.println();

        barista.orderAmericano(Intensity.STRONG, 200);
        System.out.println();

        barista.orderPumpkinSpiceLatte(Intensity.NORMAL, 40, 15);
        System.out.println();

        // Display all orders
        barista.showAllOrders();
    }
}

