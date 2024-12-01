package oop.master;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import oop.master.enums.CarTypes;
import oop.master.enums.PassengerTypes;
import oop.master.queue.LimitQueue;
import oop.master.queue.LinearQueue;
import oop.master.queue.PriorityQueue;
import oop.master.services.ElectricStation;
import oop.master.services.GasStation;
import oop.master.services.PeopleDinner;
import oop.master.services.RobotDinner;

class CarStationTest {

    private PeopleDinner peopleDinnerService;
    private RobotDinner robotDinnerService;
    private GasStation gasFuelService;
    private ElectricStation electricFuelService;
    private CarStation carGasPeopleStation;
    private CarStation carGasRobotStation;
    private CarStation carElectricPeopleStation;
    private CarStation carElectricRobotStation;

    @BeforeEach
    void setUp() {
        // Mock Dineable and Refuelable services
        peopleDinnerService = new PeopleDinner();
        robotDinnerService = new RobotDinner();
        gasFuelService = new GasStation();
        electricFuelService = new ElectricStation();

        // Create CarStation instances with appropriate services with different queue implementations:
        carGasPeopleStation = new CarStation(peopleDinnerService, gasFuelService, new LinearQueue<>());
        carGasRobotStation = new CarStation(robotDinnerService, gasFuelService, new LimitQueue<>(2));
        carElectricPeopleStation = new CarStation(peopleDinnerService, electricFuelService, new PriorityQueue<>(CarComparator::compareByConsumption));
        carElectricRobotStation = new CarStation(robotDinnerService, electricFuelService, new PriorityQueue<>(CarComparator::compareByDinner));

    }


    @Test
    void testPriorityQueueFuelServing() {
        // Add cars to the priority queue station by Fuel
        Car car1 = new Car(1, CarTypes.ELECTRIC, PassengerTypes.PEOPLE, true, 80); 
        Car car2 = new Car(2, CarTypes.ELECTRIC, PassengerTypes.PEOPLE, false, 90); 
        carElectricPeopleStation.addCar(car1);
        carElectricPeopleStation.addCar(car2);
        carElectricPeopleStation.serveCar();  // The car with higher consumption should be served first

        assertEquals(2, carElectricPeopleStation.getFuelService().getCount());
    }
    @Test
    void testPriorityQueueDinningServing() {
        // Add cars to the priority queue station by Dinning
        Car car1 = new Car(1, CarTypes.ELECTRIC, PassengerTypes.ROBOTS, false, 70);
        Car car2 = new Car(2, CarTypes.ELECTRIC, PassengerTypes.ROBOTS, true, 4);
        Car car3 = new Car(3, CarTypes.ELECTRIC, PassengerTypes.ROBOTS, true, 10);
        carElectricRobotStation.addCar(car1);
        carElectricRobotStation.addCar(car2);
        carElectricRobotStation.addCar(car3);

        assertEquals(car2, carElectricRobotStation.getQueue().peek());

        carElectricRobotStation.serveCar();  // The passagers that want to take dinner should be served first

        assertEquals(2, carElectricRobotStation.getDinnerService().getCount());
    }
    @Test
    void testLimitQueueCapacity() {
        Car car1 = new Car(1, CarTypes.GAS, PassengerTypes.ROBOTS, false, 70);
        Car car2 = new Car(2, CarTypes.GAS, PassengerTypes.ROBOTS, true, 4);
        Car car3 = new Car(3, CarTypes.GAS, PassengerTypes.ROBOTS, true, 10);
        carGasRobotStation.addCar(car1);
        carGasRobotStation.addCar(car2);
        Exception e = assertThrows(IllegalStateException.class, () -> carGasRobotStation.addCar(car3));
        System.out.println(e.getMessage());
        assertEquals(2, carGasRobotStation.getQueue().size());
    }

}
