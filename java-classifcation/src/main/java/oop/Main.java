package oop;



public class Main {
  public static void main(String[] args) {
      FileReader filer = new FileReader();
      filer.readJsonFile("java-classifcation/src/main/resources/test-input.json");
      // Print out the string file
      filer.printJsonString();
      String[] traits = {"HAIRY", "TALL"};
      Character creature = new Character(0, false, "Kashyyyk", 253, traits);
      creature.displayCreatureInfo();
  }
}