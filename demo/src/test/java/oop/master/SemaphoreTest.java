package oop.master;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import oop.master.car_utils.Car;
import oop.master.enums.CarTypes;
import oop.master.enums.PassengerTypes;
import oop.master.queue.*;
import oop.master.services.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SemaphoreTest {

    private Semaphore semaphore;
    private Gson gson;

    @BeforeEach
    void setUp() {
        semaphore = new Semaphore();
        gson = new GsonBuilder().create();

        Dineable peopleDinnerService = new PeopleDinner();
        Dineable robotDinnerService = new RobotDinner();
        Refuelable gasFuelService = new GasStation();
        Refuelable electricFuelService = new ElectricStation();

        // Register CarStations
        semaphore.registerStation(CarTypes.GAS, PassengerTypes.PEOPLE, 
            new CarStation(peopleDinnerService, gasFuelService, new LinearQueue<>()));
        semaphore.registerStation(CarTypes.ELECTRIC, PassengerTypes.ROBOTS, 
            new CarStation(robotDinnerService, electricFuelService, new LimitQueue<>(3)));
    }

    @Test
    void testGuideElectricCarWithDining() {
        String jsonCar = """
        {
          "id": 1,
          "type": "ELECTRIC",
          "passengers": "ROBOTS",
          "isDining": true,
          "consumption": 30
        }
        """;

        Car electricCar = gson.fromJson(jsonCar, Car.class);
        semaphore.guideCar(electricCar);

        assertEquals(1, semaphore.getCarsCountForType(CarTypes.ELECTRIC, PassengerTypes.ROBOTS));
        assertTrue(electricCar.isDining());
    }

    @Test
    void testServeElectricCar() {
        String jsonCar = """
        {
          "id": 2,
          "type": "ELECTRIC",
          "passengers": "ROBOTS",
          "isDining": true,
          "consumption": 40
        }
        """;

        Car electricCar = gson.fromJson(jsonCar, Car.class);
        semaphore.guideCar(electricCar);

        assertEquals(1, semaphore.getCarsCountForType(CarTypes.ELECTRIC, PassengerTypes.ROBOTS));
        semaphore.serveCarsType(CarTypes.ELECTRIC, PassengerTypes.ROBOTS);
        assertEquals(0, semaphore.getCarsCountForType(CarTypes.ELECTRIC, PassengerTypes.ROBOTS));
        assertEquals(1, semaphore.getDinnerServedCountForType(CarTypes.ELECTRIC, PassengerTypes.ROBOTS));
    }

    @Test
    void testInvalidCarThrowsException() {
        String invalidJsonCar = """
        {
          "id": 3,
          "type": "HYBRID",
          "passengers": "ALIENS",
          "isDining": false,
          "consumption": 25
        }
        """;

        Exception e = assertThrows(IllegalArgumentException.class, () -> {
            Car car = gson.fromJson(invalidJsonCar, Car.class);
            semaphore.guideCar(car);
        });
        System.out.println(e.getMessage());
    }
}

