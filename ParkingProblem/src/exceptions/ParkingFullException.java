package exceptions;

public class ParkingFullException extends RuntimeException {

    public ParkingFullException() {
        super("Parking Full");
    }
}
