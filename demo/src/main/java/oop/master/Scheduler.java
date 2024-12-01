package oop.master;

import oop.master.enums.CarTypes;
import oop.master.enums.PassengerTypes;

import java.util.concurrent.*;

import oop.master.car_utils.Car;

public class Scheduler {

    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private final Semaphore semaphore;

    public Scheduler(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    // Method to start the serve car process for specific car type and passenger type
    public void startServeCarProcess(long serveCarInterval, CarTypes carType, PassengerTypes passengerType) {
        executorService.submit(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    // Serve cars for the specific car type and passenger type
                    semaphore.serveCarsType(carType, passengerType);
                    Thread.sleep(serveCarInterval * 1000); // Sleep for the specified interval
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    // Method to start the guide car process for specific car type and passenger type
    public void startGuideCarProcess(long guideCarInterval, Car car) {
        executorService.submit(() -> {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    // Simulate guiding cars (can be replaced with actual logic to guide cars)
                    semaphore.guideCar(car);
                    Thread.sleep(guideCarInterval * 1000); // Sleep for the specified interval
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
    }

    // Method to stop the scheduler and all threads
    public void stopScheduler() {
        executorService.shutdownNow(); // Interrupts all tasks
    }
}
