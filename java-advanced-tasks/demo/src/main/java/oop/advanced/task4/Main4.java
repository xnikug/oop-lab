package oop.advanced.task4;

import oop.advanced.barista.Barista;
import oop.advanced.coffe_enums.Intensity;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Barista barista = new Barista();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("Welcome to the Coffee Shop!");
            System.out.println("Please choose an option:");
            System.out.println("1. Order Cappuccino");
            System.out.println("2. Order Americano");
            System.out.println("3. Order Pumpkin Spice Latte");
            System.out.println("4. Show all orders");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Order Cappuccino
                    System.out.print("Enter intensity (LIGHT, MEDIUM, STRONG): ");
                    Intensity intensity = Intensity.valueOf(scanner.nextLine().toUpperCase());
                    System.out.print("Enter amount of milk in ml: ");
                    int milk = scanner.nextInt();
                    scanner.nextLine();

                    barista.orderCappuccino(intensity, milk);
                    System.out.println("Cappuccino ordered!\n");
                    break;

                case 2:
                    // Order Americano
                    System.out.print("Enter intensity (LIGHT, MEDIUM, STRONG): ");
                    intensity = Intensity.valueOf(scanner.nextLine().toUpperCase());
                    System.out.print("Enter amount of water in ml: ");
                    int water = scanner.nextInt();
                    scanner.nextLine();

                    barista.orderAmericano(intensity, water);
                    System.out.println("Americano ordered!\n");
                    break;

                case 3:
                    // Order Pumpkin Spice Latte
                    System.out.print("Enter intensity (LIGHT, MEDIUM, STRONG): ");
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
                    // Show all orders
                    barista.showAllOrders();
                    System.out.println();
                    break;

                case 5:
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
