import org.junit.Before;

import static org.junit.Assert.*;

public class ParkingLotTest {


    @org.junit.Test
    public void testParkWithSpace() throws Exception {

        ParkingLot  parkingLot = new ParkingLot();
        int car1_token= parkingLot.park(new Car(1212));
        int car2_token=parkingLot.park(new Car(1213));
        assertEquals(1,car1_token);
        assertEquals(2,car2_token);
    }

    @org.junit.Test(expected = ParkingFullException.class)
    public void testParkWithParkingFullException() throws Exception {

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.park(new Car(1212));
        parkingLot.park(new Car(1213));

        assertEquals(3, parkingLot.park(new Car(1214)));
    }

    @org.junit.Test(expected = CarAlreadyParkedException.class)
    public void testParkWithCarAlreadyParkedException() throws Exception {

        ParkingLot parkingLot = new ParkingLot();
        parkingLot.park(new Car(1212));
        assertEquals(2, parkingLot.park(new Car(1212)));

    }

    @org.junit.Test
    public void testUnPark() throws Exception {
        Car car=new Car(1212);
        ParkingLot parkingLot = new ParkingLot();
        int token=parkingLot.park(car);
        assertEquals(car, parkingLot.unPark(token));

    }

    @org.junit.Test(expected = CarNotParkedException.class)
    public void testUnParkWithCarNotParkedException() throws Exception {
        ParkingLot parkingLot=new ParkingLot();
        parkingLot.unPark(12134);
    }

}