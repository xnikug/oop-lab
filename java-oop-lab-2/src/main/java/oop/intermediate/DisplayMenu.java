package oop.intermediate;
import java.util.Scanner;
import oop.intermediate.assistant.*;
import oop.intermediate.display.*;

public class DisplayMenu {
    private Assistant assistant;
    private Scanner scanner;

    // Constructor initializes Assistant and Scanner
    public DisplayMenu(Assistant assistant) {
        this.assistant = assistant;
        this.scanner = new Scanner(System.in);
    }

    // Start the menu
    public void start() {
        while (true) {
            System.out.println("==== Display Assistant Menu ====");
            System.out.println("1. Create a Display and assign it to Assistant");
            System.out.println("2. Compare Displays");
            System.out.println("3. Buy a Display");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Display display = createDisplay();
                    assistant.assignDisplay(display);
                    System.out.println("Assigned " + display.getModel() + " to " + assistant.getAssistantName());
                    break;
                case 2:
                    assistant.assist();
                    break;
                case 3:
                    buyDisplay();
                    break;
                case 4:
                    System.out.println("Exiting menu.");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // Method to create a new Display
    private Display createDisplay() {
        System.out.print("Enter Display width: ");
        int width = scanner.nextInt();
        System.out.print("Enter Display height: ");
        int height = scanner.nextInt();
        System.out.print("Enter Display ppi: ");
        float ppi = scanner.nextFloat();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Display model: ");
        String model = scanner.nextLine();

        Display display = new Display(width, height, ppi, model);
        System.out.println("Created " + display.getModel() + " Display.");
        return display;
    }

    // Method to buy a display by model name
    private void buyDisplay() {
        System.out.print("Enter the model of the Display to buy: ");
        String model = scanner.nextLine();

        Display displayToBuy = null;
        for (Display display : assistant.getAssignedDisplays()) {
            if (display.getModel().equals(model)) {
                displayToBuy = display;
                break;
            }
        }
        if (displayToBuy == null){
            System.out.println("Display was not found");
            return;
        }
        assistant.buyDisplay(displayToBuy);
    }
}
