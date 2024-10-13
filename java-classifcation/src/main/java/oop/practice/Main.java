package oop.practice;

import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        FileReader filer = new FileReader();
        filer.readJsonFile("java-classifcation/src/main/resources/input.json");
        filer.splitJsonIntoObjects();
        // Print out the string file
        String dataString = filer.getIndividualJsons().getFirst();

        // Convert String Data to object
        GsonBuilder builder = new GsonBuilder(); 
        Gson gson = builder.create(); 
        DataWrapper dataC = gson.fromJson(dataString, DataWrapper.class);
        View view = new View(dataC);
        view.runQuery(dataC);
        DataWrapper output = new DataWrapper();
        output.setData(view.getOutput());
        String jsonOutput = gson.toJson(output);
        System.out.println(jsonOutput);

      
    }
}
