package oop.intermediate.text_parsing;

import java.nio.file.Files;
import java.nio.file.Paths;


public class FileReader {
    public String readFileIntoString(String path) 
    {
        try
        {
            return new String(Files.readAllBytes(Paths.get(path)));
        }
        catch(Exception IOException)
        {
            return null;
        }

    }
}

