package oop.practice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
  public static void main(String[] args) {
      FileReader filer = new FileReader();
      filer.readJsonFile("java-classifcation/src/main/resources/input.json");
      filer.splitJsonIntoObjects();
      // Print out the string file
      String dataString = filer.getIndividualJsons().getFirst();
      //System.out.println(dataString);
      
      // Convert String Data to object
      GsonBuilder builder = new GsonBuilder(); 
      Gson gson = builder.create(); 
      DataWrapper dataC = gson.fromJson(dataString, DataWrapper.class);
      System.out.println("Data:");
      for (Character dataElement : dataC.getData()){
        dataElement.displayCreatureInfo();
      }
      System.out.println("Queried creatures:");
      for (Character dataElement : dataC.fetchByEvenId()){
        dataElement.displayCreatureInfo();
      }
  }
}