import static org.junit.Assert.*;

public class ParkingLotTest {

    @org.junit.Test
    public void testParkWithSpace() throws Exception {

        ParkingLot parkingLot = new ParkingLot();

        assertEquals(1, parkingLot.park(new Car(1212)));
        assertEquals(2, parkingLot.park(new Car(1213)));
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


}