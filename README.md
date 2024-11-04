# Laboratory #4

This lab focuses on applying object-oriented programming (OOP) principles to create a coffee ordering system using Java. The program utilizes enums and classes to simulate a barista taking various coffee orders with specific attributes and intensity levels.

## Features

- **Coffee Intensity and Types**: Allows ordering of different types of coffee, each with varying intensities (e.g., LIGHT, NORMAL, STRONG) and specific attributes such as milk quantity, water amount, syrup type, and pumpkin spice amount.
  
- **Barista Class**: Manages coffee orders, processes different types of coffee requests, and stores all orders for later review.

- **Menu-Driven Interface**: Provides a command-line menu to allow users to enter specific attributes, and view all orders placed.

## Class Overview

### 1. Barista
The `Barista` class simulates a barista handling multiple coffee orders. It manages the processing and storage of orders and displays all orders upon request.

**Methods**:
- `orderCappuccino(Intensity intensity, int milk)`: Places an order for a Cappuccino with specified intensity and milk amount.
- `orderAmericano(Intensity intensity, int water)`: Places an order for an Americano with specified intensity and water amount.
- `orderPumpkinSpiceLatte(Intensity intensity, int milk, int pumpkinSpice)`: Places an order for a Pumpkin Spice Latte with specified intensity, milk amount, and pumpkin spice amount.
- `orderSyrupCappuccino(Intensity intensity, int milk, SyrupType syrupType)`: Places an order for a Syrup Cappuccino with specified intensity, milk amount, and syrup type.
- `showAllOrders()`: Displays all orders taken by the barista.

### 2. Intensity (Enum)
The `Intensity` enum represents different coffee intensities:
- `LIGHT`
- `NORMAL`
- `STRONG`

This enum is used to define the strength of each coffee order.

### 3. SyrupType (Enum)
The `SyrupType` enum represents various syrup options for the Syrup Cappuccino:
- `MACADAMIA`
- `VANILLA`
- `COCONUT`
- `CARAMEL`
- `CHOCOLATE`
- `POPCORN`

This enum provides flavor options for the cappuccino with syrup.


### Sample Menu

```plaintext
1. Order Cappuccino
2. Order Americano
3. Order Pumpkin Spice Latte
4. Order Syrup Cappuccino
5. Show all orders
6. Exit
