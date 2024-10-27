# Display Assistant Application

This Java application helps users manage and compare different display monitors using a menu-driven interface. The `DisplayAssistant` application allows users to create display objects, assign them to an assistant, compare display specifications, and select a display to purchase.

## Table of Contents
1. [Features](#features)
2. [Class Overview](#class-overview)
3. [Getting Started](#getting-started)
4. [Usage](#usage)

## Features
- Create and configure display objects with properties like width, height, PPI (pixels per inch), and model.
- Assign displays to an assistant for easy management.
- Compare displays to determine which is larger or sharper.
- Remove a display from the assistant's list when purchasing.

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

### 3. DisplayMenu
The `DisplayMenu` class handles user interaction through a command-line menu:
- Allows users to create displays, assign them, compare them, and purchase displays.

## Getting Started
1. Clone the repository or download the source code.
2. Ensure you have JDK 8 or higher installed on your machine.
3. Navigate to the project directory and compile the Java files.

```bash
javac src/main/java/oop/intermediate/*.java
