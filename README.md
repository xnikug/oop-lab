# Laboratory #2

This lab focuses on object-oriented programming (OOP) principles using Java. Examples include to create a display management application, and to handle text data from files.

## Features

-`Display Class`: Represents individual display monitors with properties such as width, height, pixels per inch (PPI), and model. It includes methods for comparing size and sharpness between displays.

-`Assistant Class`: Acts as a manager for multiple display objects, enabling the assignment of displays and facilitating comparisons between them. It also provides functionality to "purchase" a display by removing it from the list.

-`FileReader Functionality`: A separate class is utilized to read data from text files, allowing users to import display specifications from an external source. This feature demonstrates how to handle file input in Java and process the data for creating display objects.

-`User Interaction`: A menu-driven interface allows users to create displays, assign them to the assistant, and compare their specifications. This interaction illustrates how OOP concepts like encapsulation and modularity can enhance code organization and reusability.

## Class Overview

### 1. Display
The `Display` class represents a display monitor with the following properties:
- `int width`: Width of the display in pixels.
- `int height`: Height of the display in pixels.
- `float ppi`: Pixels per inch, indicating the display's sharpness.
- `String model`: The model name of the display.

Methods:
- `compareSize(Display m)`: Compares the size of the current display with another display.
- `compareSharpness(Display m)`: Compares the sharpness (PPI) of the current display with another display.
- `compareWithMonitor(Display m)`: Compares both size and sharpness with another display.

### 2. Assistant
The `Assistant` class helps manage multiple displays and provides functionality to compare and purchase displays:
- `String assistantName`: The name of the assistant.
- `List<Display> assignedDisplays`: A list of displays assigned to the assistant.

Methods:
- `void assignDisplay(Display d)`: Adds a display to the assistant's list.
- `void assist()`: Compares all assigned displays and provides feedback.
- `Display buyDisplay(Display d)`: Removes a display from the list and returns it.

### 3. FileReader
The `FileReader` class is responsible for reading display specifications from a text file. This functionality allows users to import display data without manual input.

Methods:
- `String readFileIntoString(String path)`: Reads the contents of the specified text file into a string.

### 4. TextData
The `TextData` class represents the content of a text file, providing an analysis of its contents:
- `String fileName`: The name of the text file.
- `String text`: The raw text content of the file.
- `int numberOfVowels`: The count of vowels in the text.
- `int numberOfConsonants`: The count of consonants in the text.
- `int numberOfLetters`: The total count of letters in the text.
- `int numberOfSentences`: The count of sentences in the text.
- `String longestWord`: The longest word found in the text.

Methods:
- `TextData(String text)`: Constructor that processes the text to calculate properties.
- `String getFilename()`: Returns the name of the file.
- `String getText()`: Returns the text content.
- `int getNumberOfVowels()`: Returns the number of vowels.
- `int getNumberOfConsonants()`: Returns the number of consonants.
- `int getNumberOfLetters()`: Returns the total number of letters.
- `int getNumberOfSentences()`: Returns the number of sentences.
- `String getLongestWord()`: Returns the longest word found in the text.

### 5. DisplayMenu
The `DisplayMenu` class handles user interaction through a command-line menu:
- Allows users to create displays, assign them, compare them, and purchase displays.
