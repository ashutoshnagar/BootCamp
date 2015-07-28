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
    private ParkingLotObserver owner;
    private List<ParkingLotObserver> observers;

    public ParkingLot() {
    }

    public ParkingLot(ParkingLotOwner owner) {
        this.observers = new ArrayList<ParkingLotObserver>();
        observers.add(owner);
    }

    public ParkingLot(ParkingLotOwner owner, int capacity) {
        this.CAPACITY = capacity;
        this.owner = owner;
    }

    public int park(Car car) {

        if (parkingSpace.containsValue(car))
            throw new CarAlreadyParkedException();
        if (isParkingFull())
            throw new ParkingFullException();

        parkingSpace.put(++token, car);
        if (isParkingFull()) {
            owner.onFull();
            for (ParkingLotObserver agent : observers)
                agent.onFull();

        }
        return token;
    }

    public Car unPark(int token) {

        if (!parkingSpace.containsKey(token))
            throw new CarNotParkedException();
        if (isParkingFull()) {
            owner.onVacancy();
            for (ParkingLotObserver agent : observers)
                agent.onVacancy();

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
