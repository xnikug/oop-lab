package oop.master;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import oop.master.car_utils.CarComparator;
import oop.master.car_utils.CarStation;
import oop.master.enums.CarTypes;
import oop.master.enums.PassengerTypes;
import oop.master.queue.LimitQueue;
import oop.master.queue.LinearQueue;
import oop.master.queue.PriorityQueue;
import oop.master.services.Dineable;
import oop.master.services.ElectricStation;
import oop.master.services.GasStation;
import oop.master.services.PeopleDinner;
import oop.master.services.Refuelable;
import oop.master.services.RobotDinner;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore();
        Scheduler scheduler = new Scheduler(semaphore);
        Gson gson = new GsonBuilder().create();

        Dineable peopleDinnerService = new PeopleDinner();
        Dineable robotDinnerService = new RobotDinner();
        Refuelable gasFuelService = new GasStation();
        Refuelable electricFuelService = new ElectricStation();
        // Register CarStations
        semaphore.registerStation(CarTypes.GAS, PassengerTypes.PEOPLE, 
            new CarStation(peopleDinnerService, gasFuelService, new LinearQueue<>()));
        semaphore.registerStation(CarTypes.GAS, PassengerTypes.ROBOTS, 
            new CarStation(robotDinnerService, gasFuelService, new LimitQueue<>(1000)));
        semaphore.registerStation(CarTypes.ELECTRIC, PassengerTypes.PEOPLE, 
            new CarStation(peopleDinnerService, electricFuelService, new PriorityQueue<>(CarComparator::compareByConsumption)));
        semaphore.registerStation(CarTypes.ELECTRIC, PassengerTypes.ROBOTS, 
            new CarStation(robotDinnerService, electricFuelService, new PriorityQueue<>(CarComparator::compareByDinner)));        


        
        // Start the guide car and serve car processes
        scheduler.startGuideCarProcess(2);
        scheduler.startServeCarProcess(2, CarTypes.GAS, PassengerTypes.PEOPLE);
        scheduler.startServeCarProcess(2, CarTypes.GAS, PassengerTypes.ROBOTS); 
        scheduler.startServeCarProcess(2, CarTypes.ELECTRIC, PassengerTypes.PEOPLE);
        scheduler.startServeCarProcess(2, CarTypes.ELECTRIC, PassengerTypes.ROBOTS);
    }
}

