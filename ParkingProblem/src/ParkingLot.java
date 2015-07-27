import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int token = 1;
    private Map<Integer, Car> parkingSpace = new HashMap<Integer, Car>();
    private int CAPACITY = 2;

    public ParkingLot() {
    }

    public ParkingLot(int capacity) {
        this.CAPACITY = capacity;
    }

    public int park(Car car) {

        if(parkingSpace.containsValue(car))
            throw new CarAlreadyParkedException();
        if (parkingSpace.size() == CAPACITY)
            throw new ParkingFullException();

        parkingSpace.put(token, car);
        return token++;
    }
}
