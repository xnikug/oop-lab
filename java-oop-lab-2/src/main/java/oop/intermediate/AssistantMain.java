package oop.intermediate;

import oop.intermediate.assistant.Assistant;

public class AssistantMain {
    public static void main(String[] args) {
        Assistant assistant = new Assistant("Assistant model 1");
        DisplayMenu displayMenu = new DisplayMenu(assistant);
        displayMenu.start();

    }
}
