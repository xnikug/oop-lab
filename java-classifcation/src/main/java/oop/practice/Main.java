package oop.practice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        FileReader filer = new FileReader();
        // Read the input.json file
        filer.readJsonFile("java-classifcation/src/main/resources/input.json");
        filer.splitJsonIntoObjects();
        // Print out the string file
        String dataString = filer.getIndividualJsons().getFirst();
        // Convert String Data to object
        GsonBuilder builder = new GsonBuilder(); 
        Gson gson = builder.create(); 
        DataWrapper dataC = gson.fromJson(dataString, DataWrapper.class);

        // Setup a query to request data by classification
        View view = new View(dataC);
        view.runQuery(dataC);
        // Get the output and convert it to json format
        DataWrapper output = new DataWrapper();
        output.setData(view.getOutput());
        String jsonOutput = gson.toJson(output);
        
        // Write into the output.json file
        System.out.println("The JSON format output:");
        System.out.println(jsonOutput);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("java-classifcation/src/main/resources/output.json"))) {
            writer.write(jsonOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Write the classified data
        DataWrapper outputWookie = new DataWrapper();
        outputWookie.setData(dataC.fetchByWookie());
        String jsonOutputWokie = gson.toJson(outputWookie);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("java-classifcation/src/main/resources/jsonOutputWokie.json"))) {
            writer.write(jsonOutputWokie);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //...
        System.out.println("Program ended");
    }
}
