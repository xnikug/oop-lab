package oop.intermediate;

import oop.intermediate.assistant.Assistant;
import oop.intermediate.display.Display;

public class AssistantMain {
    public static void main(String[] args) {
        Display display1 = new Display(1920, 1080, 300.5f, "DisplayModelA");
        Display display2 = new Display(2560, 1440, 350.2f, "DisplayModelB");
        Display display3 = new Display(3840, 2160, 500.0f, "DisplayModelC");
        Display display4 = new Display(900, 600, 100.5f, "DisplayModelD");
        Display display5 = new Display(1000, 500, 250.2f, "DisplayModelE");
        Display display6 = new Display(1200, 900, 400.0f, "DisplayModelF");

        Assistant assistant = new Assistant("Assistant model 1");
        assistant.assignDisplay(display1);
        assistant.assignDisplay(display2);
        assistant.assignDisplay(display3);
        assistant.assignDisplay(display4);
        assistant.assignDisplay(display5);
        assistant.assignDisplay(display6);
        // Assist with display comparison
        assistant.assist();

        // Buy one of the displays
        assistant.buyDisplay(display2);
        assistant.assist();

    }
}
