/*Class used to query and visualize the classification of the data
 * Used mainly to fetch data and write data to the output file
 */
package oop.practice;

import java.util.List;
import java.util.Scanner;

public class View {
    private List<Character> output;
    View (DataWrapper dataC){
        output = dataC.getData();
    }
    public List<Character> getOutput(){
        return output;
    }
    // Menu options
    private void displayMenuOptions(){
        System.out.println("\nMenu:");
        System.out.println("1. Fetch by ID");
        System.out.println("2. Fetch by Humanoid");
        System.out.println("3. Fetch by Age");
        System.out.println("4. Fetch by Even ID");
        System.out.println("5. Fetch by Odd ID");
        System.out.println("6. Fetch by Traits");
        System.out.println("7. Fetch by Planet");
        System.out.println("8. Write data");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }
    // Run the query for the whole data set
    public void runQuery(DataWrapper dataC){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            displayMenuOptions();
            try{
                choice = scanner.nextInt();
            }catch(Exception e){
                System.out.println("Invalid input, please try again");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();

            switch (choice) {
                case 1: // Fetch by ID
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    output = dataC.fetchById(id);
                    if (output.isEmpty()){
                        System.out.println("No character found");
                        break;
                    }
                    for (Character c : output) {
                        c.displayCreatureInfo();
                    }
                    break;

                case 2: // Fetch by Humanoid
                    output = dataC.fetchByHumanoidCharacter();
                    if (output.isEmpty()){
                        System.out.println("No character found");
                        break;
                    }
                    for (Character c : output) {
                        c.displayCreatureInfo();
                    }
                    break;

                case 3: // Fetch by Age
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    output = dataC.fetchByAgeCharacter(age);
                    if (output.isEmpty()){
                        System.out.println("No character found");
                        break;
                    }
                    for (Character c : output) {
                        c.displayCreatureInfo();
                    }
                    break;

                case 4: // Fetch by Even ID
                    System.out.println("Characters with Even ID:");
                    output = dataC.fetchByEvenId();
                    if (output.isEmpty()){
                        System.out.println("No character found");
                        break;
                    }
                    for (Character c : output) {
                        c.displayCreatureInfo();
                    }
                    break;

                case 5: // Fetch by Odd ID
                    System.out.println("Characters with Odd ID:");
                    output = dataC.fetchByOddId();
                    if (output.isEmpty()){
                        System.out.println("No character found");
                        break;
                    }
                    for (Character c : output) {
                        c.displayCreatureInfo();
                    }
                    break;

                case 6: // Fetch by Traits
                    System.out.print("Enter traits separated by ';': ");
                    String[] traits = scanner.nextLine().split(";");
                    output = dataC.fetchByTraits(traits);
                    if (output.isEmpty()){
                        System.out.println("No character found");
                        break;
                    }
                    for (Character c : dataC.fetchByTraits(traits)) {
                        c.displayCreatureInfo();
                    }
                    break;

                case 7: // Fetch by Planet
                    System.out.print("Enter Planet: ");
                    String planet = scanner.nextLine();
                    output = dataC.fetchByPlanet(planet);
                    if (output.isEmpty()){
                        System.out.println("No character found");
                        break;
                    }
                    for (Character c : output) {
                        c.displayCreatureInfo();
                    }
                    break;

                case 9: // Exit
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 9);
        scanner.close();
    }
}
