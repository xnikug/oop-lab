package oop.advanced.task4;

import oop.advanced.barista.Barista;
import oop.advanced.coffe_enums.Intensity;
import oop.advanced.coffe_enums.SyrupType;

import java.util.Scanner;

public class Main4 {
    public static void printMenu(){
        System.out.println("Welcome to the Coffee Shop!");
        System.out.println("Please choose an option:");
        System.out.println("1. Order Cappuccino");
        System.out.println("2. Order Americano");
        System.out.println("3. Order Pumpkin Spice Latte");
        System.out.println("4. Order Syrup Cappucino");
        System.out.println("5. Show all orders");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }
    public static void main(String[] args) {
        Barista barista = new Barista();
        Scanner scanner = new Scanner(System.in);
        Intensity intensity;
        SyrupType syrupType;
        boolean running = true;

        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Order Cappuccino
                    System.out.print("Enter intensity (LIGHT, NORMAL, STRONG): ");
                    intensity = Intensity.valueOf(scanner.nextLine().toUpperCase());
                    System.out.print("Enter amount of milk in ml: ");
                    int milk = scanner.nextInt();
                    scanner.nextLine();

                    barista.orderCappuccino(intensity, milk);
                    System.out.println("Cappuccino ordered!\n");
                    break;

                case 2:
                    // Order Americano
                    System.out.print("Enter intensity (LIGHT, NORMAL, STRONG): ");
                    intensity = Intensity.valueOf(scanner.nextLine().toUpperCase());
                    System.out.print("Enter amount of water in ml: ");
                    int water = scanner.nextInt();
                    scanner.nextLine();

                    barista.orderAmericano(intensity, water);
                    System.out.println("Americano ordered!\n");
                    break;

                case 3:
                    // Order Pumpkin Spice Latte
                    System.out.print("Enter intensity (LIGHT, NORMAL, STRONG): ");
                    intensity = Intensity.valueOf(scanner.nextLine().toUpperCase());
                    System.out.print("Enter amount of milk in ml: ");
                    milk = scanner.nextInt();
                    System.out.print("Enter amount of pumpkin spice in mg: ");
                    int pumpkinSpice = scanner.nextInt();
                    scanner.nextLine();

                    barista.orderPumpkinSpiceLatte(intensity, milk, pumpkinSpice);
                    System.out.println("Pumpkin Spice Latte ordered!\n");
                    break;
                case 4:
                    // Order Syrup Cappuccino
                    System.out.print("Enter intensity (LIGHT, NORMAL, STRONG): ");
                    intensity = Intensity.valueOf(scanner.nextLine().toUpperCase());
                    System.out.print("Enter amount of milk in ml: ");
                    milk = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter syrupType (MACADAMIA, VANILLA, COCONUT, CARAMEL, CHOCOLATE, POPCORN): ");
                    syrupType = SyrupType.valueOf(scanner.nextLine().toUpperCase());

                    barista.orderSyrupCappuccino(intensity, milk, syrupType);
                    System.out.println("Syrup Cappuccino ordered!\n");
                    break;

                case 5:
                    // Show all orders
                    barista.showAllOrders();
                    System.out.println();
                    break;

                case 6:
                    running = false;
                    System.out.println("Thank you for visiting the Coffee Shop!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    break;
            }
        }

        scanner.close();
    }
}
