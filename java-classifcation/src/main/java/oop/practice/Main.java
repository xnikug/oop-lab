package oop.practice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
  public static void main(String[] args) {
      FileReader filer = new FileReader();
      filer.readJsonFile("java-classifcation/src/main/resources/test-input.json");
      filer.splitJsonIntoObjects();
      // Print out the string file
      String dataString = filer.getIndividualJsons().getFirst();
      //System.out.println(dataString);
      
      // Convert String Data to object
      ObjectMapper objectMapper = new ObjectMapper();
      //DataWrap data_ch = objectMapper.readValue(dataString, );
      GsonBuilder builder = new GsonBuilder(); 
      Gson gson = builder.create(); 
      DataWrap dataC = gson.fromJson(dataString, DataWrap.class); 
      System.out.println(dataC.data.getFirst().getAge());
      String[] traits = {"HAIRY", "TALL"};
      Character creature = new Character(0, false, "Kashyyyk", 253, traits);
      //creature.displayCreatureInfo();
  }
}