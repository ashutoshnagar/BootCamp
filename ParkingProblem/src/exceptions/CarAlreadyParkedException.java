package exceptions;

public class CarAlreadyParkedException extends RuntimeException {
    public CarAlreadyParkedException()
    {
        super("model.Car Already Parked");
    }
}
