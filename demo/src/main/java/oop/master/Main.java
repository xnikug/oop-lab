package oop.master;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    private static final Path QUEUE_DIR = Paths.get("src/main/resources/queue");
    private static final Path PENDING_DIR = Paths.get("src/main/resources/pending");
    private static final ExecutorService executorService = Executors.newCachedThreadPool();
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore();
        Scheduler scheduler = new Scheduler(semaphore);

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
        scheduler.startServeCarProcess(4, CarTypes.GAS, PassengerTypes.PEOPLE);
        scheduler.startServeCarProcess(4, CarTypes.GAS, PassengerTypes.ROBOTS); 
        scheduler.startServeCarProcess(4, CarTypes.ELECTRIC, PassengerTypes.PEOPLE);
        scheduler.startServeCarProcess(4, CarTypes.ELECTRIC, PassengerTypes.ROBOTS);
        scheduler.startPrintStatsProcess(5);
        //onitorDirectories();
    }
}

