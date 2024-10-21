/*Class used to store the Character */
package oop.practice;


public class Character {
    private int id;
    private Boolean isHumanoid;
    private String planet;
    private int age = -1;
    // Traits to be defined by upper case strictly
    private String[] traits;
    public Character() {

    }

    public Character(int id, boolean isHumanoid, String planet, int age, String[] traits) {
        this.id = id;
        this.isHumanoid = isHumanoid;
        this.planet = planet;
        this.age = age;
        this.traits = traits;
    }

    public int getId() {
        return id;
    }

    public Boolean isHumanoid() {
        return isHumanoid;
    }

    public String getPlanet() {
        return planet;
    }

    public int getAge() {
        return age;
    }

    public String[] getTraits() {
        return traits;
    }

    public void displayCreatureInfo() {
        System.out.println("ID: " + id);
        if (isHumanoid != null){
            System.out.println("Humanoid: " + isHumanoid);
        }
        if (planet != null){
            System.out.println("Planet: " + planet);
        }
        if (age != -1){
            System.out.println("Age: " + age);
        }
        if (traits == null){
            System.out.println("--------------------");
            return;
        }
        System.out.print("Traits: ");
        for (String trait : traits) {
            System.out.print(trait + "; ");
        }
        System.out.println();
        System.out.println("--------------------");
    }
}

