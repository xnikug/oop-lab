package oop;

public class Character {
    private int id;
    private boolean isHumanoid;
    private String planet;
    private int age;
    private String[] traits;

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

    public boolean isHumanoid() {
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
        System.out.println("Humanoid: " + isHumanoid);
        System.out.println("Planet: " + planet);
        System.out.println("Age: " + age);
        System.out.print("Traits: ");
        for (String trait : traits) {
            System.out.print(trait + "; ");
        }
        System.out.println();
    }
}

