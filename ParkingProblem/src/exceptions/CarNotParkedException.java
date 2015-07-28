package exceptions;

public class CarNotParkedException extends RuntimeException {
    public CarNotParkedException(){
        super("model.Car Was not parked");
    }
}
