package oop.master.car_utils;

import oop.master.queue.Queue;
import oop.master.services.Dineable;
import oop.master.services.Refuelable;

public class CarStation {
    private Dineable dinnerService;
    private Refuelable fuelService;
    private Queue<Car> queue;

	public Dineable getDinnerService() {
		return this.dinnerService;
	}

	public Refuelable getFuelService() {
		return this.fuelService;
	}

	public Queue<Car> getQueue() {
		return this.queue;
	}

    public CarStation(Dineable dinnerService, Refuelable fuelService, Queue<Car> queue) {
        this.dinnerService = dinnerService;
        this.fuelService = fuelService;
        this.queue = queue;
    }

    public void serveCars(){
        while (!queue.isEmpty()){
            Car car = queue.dequeue();
            if (car != null){

                if (car.isDining()){
                    dinnerService.serveDinner(car.getId().toString());
                }

                fuelService.refuel(car.getId().toString());
            }
        }
    }
    public void addCar(Car car){
        queue.enqueue(car);
    }

    
}
