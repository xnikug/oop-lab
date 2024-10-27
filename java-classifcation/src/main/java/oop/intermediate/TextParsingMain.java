package oop.intermediate;

import java.io.IOException;

import oop.intermediate.text_parsing.*;
public class TextParsingMain {
    public static void main(String[] args) throws IOException{
        System.out.println(args[0]);
        TextData inputData = new TextData(args[0]);
        System.out.println(inputData.toString());
    }
}