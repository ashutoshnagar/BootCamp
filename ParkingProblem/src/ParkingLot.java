import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int token;
    private Map<Integer, Car> parkingSpace = new HashMap<Integer, Car>();
    private int CAPACITY = 2;
    private ParkingLotOwner parkingLotOwner;

    public ParkingLot() {
    }

    public ParkingLot(ParkingLotOwner parkingLotOwner)
    {
        this.parkingLotOwner=parkingLotOwner;
    }

    public ParkingLot(ParkingLotOwner parkingLotOwner,int capacity) {
        this.CAPACITY = capacity;
        this.parkingLotOwner=parkingLotOwner;
    }

    public int park(Car car) {

        if(parkingSpace.containsValue(car))
            throw new CarAlreadyParkedException();
        if (isParkingFull())
            throw new ParkingFullException();

        parkingSpace.put(++token, car);
        if(isParkingFull())
           parkingLotOwner.onFull();
        return token;
    }

    public Car unPark(int token) {

        if(!parkingSpace.containsKey(token))
            throw new CarNotParkedException();
        if(isParkingFull())
            parkingLotOwner.onNoMoreFull();
        return parkingSpace.remove(token);

    }
    public boolean isParkingFull()
    {
        return parkingSpace.size()==CAPACITY;
    }

}
