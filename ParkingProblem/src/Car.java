public class Car {
    private int carNo;

    public int getCarNo() {
        return carNo;
    }

    public Car(int carNo) {
        this.carNo = carNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        return carNo == car.carNo;

    }

    @Override
    public int hashCode() {
        return carNo;
    }
}