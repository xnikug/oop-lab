package oop.practice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        FileReader filer = new FileReader();
        // Read the input.json file
        String jsonField = filer.readJsonFile("java-classifcation/src/main/resources/input.json");
        List<String> splitJsonFields = filer.splitJsonIntoObjects(jsonField);
        // Print out the string file
        String dataString = splitJsonFields.getFirst();
        // Convert String Data to object
        GsonBuilder builder = new GsonBuilder(); 
        Gson gson = builder.create(); 
        CharacterWrapper characterData = gson.fromJson(dataString, CharacterWrapper.class);

        // Setup a query to request data by classification
        View view = new View(characterData);
        view.runQuery(characterData);
        // Get the output and convert it to json format
        CharacterWrapper output = new CharacterWrapper();
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
        String StarWars;
        CharacterWrapper outputWookie = new CharacterWrapper();
        outputWookie.setData(characterData.fetchByWookie());
        String jsonOutputWokie = gson.toJson(outputWookie);
        CharacterWrapper outputEwok = new CharacterWrapper();
        outputEwok.setData(characterData.fetchByEwok());
        String jsonOutputEwok = gson.toJson(outputEwok);
        StarWars = "[" + jsonOutputWokie +","+ jsonOutputEwok + "]";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("java-classifcation/src/main/resources/jsonStarWars.json"))) {
            writer.write(StarWars);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String Marvel;
        CharacterWrapper outputAsgardian = new CharacterWrapper();
        outputAsgardian.setData(characterData.fetchByAsgardian());
        String jsonOutputAsgardian = gson.toJson(outputAsgardian);
        Marvel = "[" + jsonOutputAsgardian + "]";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("java-classifcation/src/main/resources/jsonOutputMarvel.json"))) {
            writer.write(Marvel);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String Hitchhiker;
        CharacterWrapper outputVogon = new CharacterWrapper();
        outputVogon.setData(characterData.fetchByVogon());
        String jsonOutputVogon = gson.toJson(outputVogon);
        CharacterWrapper outputBetelgeusian = new CharacterWrapper();
        outputBetelgeusian.setData(characterData.fetchByBetelgeusian());
        String jsonOutputBetelgeusian = gson.toJson(outputBetelgeusian);
        Hitchhiker = "[" + jsonOutputVogon + "," + jsonOutputBetelgeusian + "]";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("java-classifcation/src/main/resources/jsonOutputHitchhiker.json"))) {
            writer.write(Hitchhiker);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String LordRings;
        CharacterWrapper outputElf = new CharacterWrapper();
        outputElf.setData(characterData.fetchByElf());
        String jsonOutputElf = gson.toJson(outputElf);
        CharacterWrapper outputDwarf = new CharacterWrapper();
        outputDwarf.setData(characterData.fetchByDwarf());
        String jsonOutputDwarf = gson.toJson(outputDwarf);
        LordRings = "[" + jsonOutputElf +","+ jsonOutputDwarf+"]";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("java-classifcation/src/main/resources/jsonOutputLordRings.json"))) {
            writer.write(LordRings);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //...
        System.out.println("Program ended");
    }
}
