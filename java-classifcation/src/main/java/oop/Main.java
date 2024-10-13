package oop;


public class Main {
  public static void main(String[] args) {
      String[] traits = {"HAIRY", "TALL"};
      Character creature = new Character(0, false, "Kashyyyk", 253, traits);
      creature.displayCreatureInfo();
  }
}