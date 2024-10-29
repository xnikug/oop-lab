/*This class has no setters */

package oop.intermediate.text_parsing;

import java.io.IOException;

public class TextData {
    private String fileName;
    private String text;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;
    private String longestWord;

    // Constructor
    public TextData(String fileName) throws IOException {
        this.fileName = fileName;
        // Call the FileReader instance anonymously
        this.text = new FileReader().readFileIntoString(fileName);
        processText();
    }

    // Getters 
    public String getFileName() {
        return fileName;
    }

    public String getText() {
        return text;
    }

    public int getNumberOfVowels() {
        return numberOfVowels;
    }

    public int getNumberOfConsonants() {
        return numberOfConsonants;
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public int getNumberOfSentences() {
        return numberOfSentences;
    }

    public String getLongestWord() {
        return longestWord;
    }

    private void processText() throws IOException {
        if (this.text == null)
        {
            throw new IOException("Invalid file path");
        }

        this.numberOfVowels = 0;
        this.numberOfConsonants = 0;
        this.numberOfLetters = 0;
        this.numberOfSentences = 0;
        this.longestWord = null;

        if (text == null){
            return;
        }

        String[] words = text.split("[\\s.,!?;]+");
        String vowels = "aeiou";
        String consonants = "bcdfghjklmnpqrstvwxyz";

        for (String word : words) {
            if (word.length() > (longestWord == null ? 0 : longestWord.length())) {
                longestWord = word;
            }

            for (char c : word.toLowerCase().toCharArray()) {
                if (Character.isLetter(c)) {
                    numberOfLetters++;
                    if (vowels.indexOf(c) != -1) {
                        numberOfVowels++;
                    } else if (consonants.indexOf(c) != -1){
                        numberOfConsonants++;
                    }
                }
            }
        }

        // Count sentences based on '.', '!', or '?' on the text that is striped of whitespaces
        this.numberOfSentences = text.strip().split("[.!?]").length;
    }

    @Override
    public String toString() {
        return "TextData{" +
                "fileName='" + fileName + '\'' +
                ", numberOfVowels=" + numberOfVowels +
                ", numberOfConsonants=" + numberOfConsonants +
                ", numberOfLetters=" + numberOfLetters +
                ", numberOfSentences=" + numberOfSentences +
                ", longestWord='" + longestWord + '\'' +
                '}';
    }
}