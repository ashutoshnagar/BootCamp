import exceptions.CarAlreadyParkedException;
import exceptions.CarNotParkedException;
import exceptions.ParkingFullException;
import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private int token;
    private Map<Integer, Car> parkingSpace = new HashMap<Integer, Car>();
    private int CAPACITY = 2;
    private List<ParkingLotObserver> observers;

    public ParkingLot() {
    }

    public ParkingLot(TestParkingLotOwner owner) {
        this.observers = new ArrayList<ParkingLotObserver>();
        observers.add(owner);
    }

    public ParkingLot(ParkingLotOwner owner, int capacity) {
        this.CAPACITY = capacity;
       observers.add(owner);
    }

    public int park(Car car) {

        if (parkingSpace.containsValue(car))
            throw new CarAlreadyParkedException();
        if (isParkingFull())
            throw new ParkingFullException();

        parkingSpace.put(++token, car);
        if (isParkingFull()) {

            for (ParkingLotObserver observer : observers)
                observer.onFull();

        }
        return token;
    }

    public Car unPark(int token) {

        if (!parkingSpace.containsKey(token))
            throw new CarNotParkedException();
        if (isParkingFull()) {
            for (ParkingLotObserver observer : observers)
                observer.onVacancy();

        }
        return parkingSpace.remove(token);

    }

    public boolean isParkingFull() {
        return parkingSpace.size() == CAPACITY;
    }



    public void register(ParkingLotObserver agent) {
        observers.add(agent);
    }

    public void unRegister(ParkingLotObserver agent) {
        observers.remove(agent);
    }
}
