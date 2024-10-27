package oop.intermediate;

import java.io.IOException;

import oop.intermediate.text_parsing.*;
public class TextParsingMain {
    public static void main(String[] args) throws IOException{
        // Multiple files processing
        if (args.length == 0){
            System.out.println("No arguments have been passed");
            return;
        }
        System.out.println("The TextData objects:");
        for (int i = 0; i < args.length; i++){
            TextData inputData = new TextData(args[i]);
            System.out.println(inputData.toString());
        }
    }
}