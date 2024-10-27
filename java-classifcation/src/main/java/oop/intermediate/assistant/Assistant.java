package oop.intermediate.assistant;

import oop.intermediate.display.*;
import java.util.ArrayList;
import java.util.List;

public class Assistant {
    private String assistantName;
    private List<Display> assignedDisplays;

    public Assistant(String assistantName) {
        this.assistantName = assistantName;
        this.assignedDisplays = new ArrayList<>();
    }

    // Setters and Getters
    public String getAssistantName(){
        return assistantName;
    }
    public void setAssistantName(String assistantName){
        this.assistantName = assistantName;
    }

    // Adds a Display to the assignedDisplays list
    public void assignDisplay(Display d) {
        assignedDisplays.add(d);
    }

    // Iterates through the assignedDisplays list to compare each Display
    public void assist() {
        if (assignedDisplays.isEmpty()) {
            System.out.println("No displays are assigned to assist.");
            return;
        }

        System.out.println("Assistant " + assistantName + " is helping with display comparisons:");
        for (int i = 0; i < assignedDisplays.size() - 1; i++) {
            Display currentDisplay = assignedDisplays.get(i);
            for (int j = i; j < assignedDisplays.size() - 1; j++) {
                Display nextDisplay = assignedDisplays.get(j + 1);

                System.out.println("Comparing " + currentDisplay.getModel()+ " (Display " + (i) + ") and " + currentDisplay.getModel() + "  (Display " + (j + 1) + "):");
                currentDisplay.compareWithMonitor(nextDisplay);
                System.out.println("-------------------------");
            }
        }
    }

    // Removes and returns a display from the list of assignedDisplays
    public Display buyDisplay(Display d) {
        if (assignedDisplays.remove(d)) {
            System.out.println("Display " + d.getModel() + " has been bought.");
            return d;
        } else {
            System.out.println("Display " + d.getModel() + " is not in the assigned displays.");
            return null;
        }
    }
}