package oop.intermediate.display;

public class Display {
    private int width;
    private int height;
    private float ppi;
    private String model;

    // Constructor
    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    // Getters and Setters
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getPpi() {
        return ppi;
    }

    public void setPpi(float ppi) {
        this.ppi = ppi;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    // Method to compare the size of this display with another display by area size
    public void compareSize(Display m) {
        int thisSize = this.width * this.height;
        int otherSize = m.width * m.height;

        if (thisSize > otherSize) {
            System.out.println(this.model + " is larger than " + m.model + " in terms of size.");
        } else if (thisSize < otherSize) {
            System.out.println(m.model + " is larger than " + this.model + " in terms of size.");
        } else {
            System.out.println(this.model + " and " + m.model + " are the same size.");
        }
    }

    // Method to compare the sharpness (PPI) of this display with another display
    public void compareSharpness(Display m) {
        if (this.ppi > m.ppi) {
            System.out.println(this.model + " is sharper than " + m.model + ".");
        } else if (this.ppi < m.ppi) {
            System.out.println(m.model + " is sharper than " + this.model + ".");
        } else {
            System.out.println(this.model + " and " + m.model + " have the same sharpness.");
        }
    }

    // Method to compare both size and sharpness with another display
    public void compareWithMonitor(Display m) {
        System.out.println("Comparing " + this.model + " with " + m.model + ":");
        compareSize(m);
        compareSharpness(m);
    }
}
