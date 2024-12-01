package oop.master;

import oop.master.car_utils.Car;
import oop.master.car_utils.CarKey;
import oop.master.enums.CarTypes;
import oop.master.enums.PassengerTypes;
import java.util.HashMap;
import java.util.Map;

public class Semaphore {

    private final Map<CarKey, CarStation> carStationMap = new HashMap<>();

    public void registerStation(CarTypes carType, PassengerTypes passengerType, CarStation station) {
        carStationMap.put(new CarKey(carType, passengerType), station);
    }

    public void guideCar(Car car) {
        CarKey key = new CarKey(car.getType(), car.getPassengers());
        CarStation targetStation = carStationMap.get(key);
        if (targetStation != null) {
            targetStation.addCar(car);
        } else {
            throw new IllegalArgumentException("Could not register station: Invalid car type or passagers type");
        }
    }

    public void serveCarsType(CarTypes carType, PassengerTypes passengerType) {
        CarKey key = new CarKey(carType, passengerType);
        CarStation station = carStationMap.get(key);
        station.serveCars();
    }

    public int getCarsCountForType(CarTypes carType, PassengerTypes passengerType) {
        CarKey key = new CarKey(carType, passengerType);
        CarStation station = carStationMap.get(key);
        return station != null ? station.getQueue().size() : 0;
    }
    public int getCarsServedCountForType(CarTypes carType, PassengerTypes passengerType) {
        CarKey key = new CarKey(carType, passengerType);
        CarStation station = carStationMap.get(key);
        return station != null ? station.getFuelService().getCount() : 0;
    }
    public int getDinnerServedCountForType(CarTypes carType, PassengerTypes passengerType) {
        CarKey key = new CarKey(carType, passengerType);
        CarStation station = carStationMap.get(key);
        return station != null ? station.getDinnerService().getCount() : 0;
    }
}
