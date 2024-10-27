package oop.intermediate;
import oop.intermediate.display.Display;

public class Main {
    public static void main(String[] args) {
        // Instantiate 3 display objects
        Display display1 = new Display(1920, 1080, 401, "Display1");
        Display display2 = new Display(2560, 1440, 500, "Display2");
        Display display3 = new Display(3840, 2160, 218, "Display3");

        // Compare displays
        display1.compareWithMonitor(display2);
        System.out.println();
        display1.compareWithMonitor(display3);
        System.out.println();
        display2.compareWithMonitor(display3);
    }
}