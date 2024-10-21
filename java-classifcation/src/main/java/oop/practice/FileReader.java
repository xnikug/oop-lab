/* This Class is a more general purpose JSON File Reader, made to handle also an array of JSON
 * Note that the original input files has only one JSON object that contains the data of the characters
*/

package oop.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private String jsonString;
    private List<String> individualJsons; // List to store individual JSON objects as strings

    // Method to read a JSON file and store it into a string
    public void readJsonFile(String filePath) {
        try {
            this.jsonString = new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to parse the JSON string and extract individual JSON objects
    public void splitJsonIntoObjects() {
        if (jsonString != null && !jsonString.isEmpty()) {
            individualJsons = new ArrayList<>();

            jsonString = jsonString.trim();
            if (jsonString.startsWith("[") && jsonString.endsWith("]")) {
                jsonString = jsonString.substring(1, jsonString.length() - 1).trim();
                //System.out.println("here is the json2: " + jsonString);
                String[] jsonObjects = jsonString.split("(?<=\\}),");

                for (String jsonObject : jsonObjects) {
                    individualJsons.add(jsonObject.trim());
                }
            }else if (jsonString.startsWith("{") && jsonString.endsWith("}")){
                // Assuming that it is a singular JSON Object!
                individualJsons.add(jsonString);
            }
        } else {
            System.out.println("No JSON data loaded.");
        }
    }

    // Method to print all individual JSON objects
    public void printIndividualJsons() {
        if (individualJsons != null && !individualJsons.isEmpty()) {
            for (String json : individualJsons) {
                System.out.println(json);
                System.out.println("-------------");
            }
        } else {
            System.out.println("No individual JSON objects to display.");
        }
    }

    // Getter method for the array of individual JSON strings
    public List<String> getIndividualJsons() {
        return individualJsons;
    }
}
