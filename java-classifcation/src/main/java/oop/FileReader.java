package oop;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    private String jsonString;

    // Method to read a JSON file and store it into a string
    public void readJsonFile(String filePath) {
        try {
            this.jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get the stored JSON string
    public String getJsonString() {
        return jsonString;
    }

    // Method to print the stored JSON string
    public void printJsonString() {
        if (jsonString != null) {
            System.out.println(jsonString);
        } else {
            System.out.println("No JSON data loaded.");
        }
    }
}

