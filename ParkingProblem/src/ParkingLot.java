import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private int token;
    private Map<Integer, Car> parkingSpace = new HashMap<Integer, Car>();
    private int CAPACITY = 2;
    private ParkingLotObserver owner;
    private List<ParkingLotObserver> agents;

    public ParkingLot() {
    }

    public ParkingLot(ParkingLotOwner owner) {
        this.agents = new ArrayList<ParkingLotObserver>();
        this.owner = owner;
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
            for (ParkingLotObserver agent : agents)
                agent.onFull();

        }
        return token;
    }

    public Car unPark(int token) {

        if (!parkingSpace.containsKey(token))
            throw new CarNotParkedException();
        if (isParkingFull()) {
            owner.onNoMoreFull();
            for (ParkingLotObserver agent : agents)
                agent.onNoMoreFull();

        }
        return parkingSpace.remove(token);

    }

    public boolean isParkingFull() {
        return parkingSpace.size() == CAPACITY;
    }

    public void register(ParkingLotObserver agent) {
        agents.add(agent);
    }

    public void unRegister(ParkingLotObserver agent) {
        agent.onNoMoreFull();
        agents.remove(agent);
    }
}
