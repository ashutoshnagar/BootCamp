import org.junit.Before;

import static org.junit.Assert.*;

public class ParkingLotTest {


    private ParkingLot parkingLot;
    private TestParkingLotOwner testParkingLotOwner;
    @Before
    public void setUp()
    {
        testParkingLotOwner =new TestParkingLotOwner();
        parkingLot=new ParkingLot(testParkingLotOwner);
        parkingLot.park(new Car(1212));
    }
    @org.junit.Test
    public void testParkWithSpace() throws Exception {
        assertEquals(2, parkingLot.park(new Car(1213)));
    }


    @org.junit.Test(expected = ParkingFullException.class)
    public void testParkWithParkingFullException() throws Exception {

        parkingLot.park(new Car(1213));
        assertEquals(3, parkingLot.park(new Car(1214)));
    }

    @org.junit.Test(expected = CarAlreadyParkedException.class)
    public void testParkWithCarAlreadyParkedException() throws Exception {

         parkingLot.park(new Car(1212));

    }

    @org.junit.Test
    public void testUnPark() throws Exception {
        assertEquals(new Car(1212), parkingLot.unPark(1));

    }

    @org.junit.Test(expected = CarNotParkedException.class)
    public void testUnParkWithCarNotParkedException() throws Exception {
        parkingLot.unPark(12134);
    }


    @org.junit.Test
    public void testOwnerNotifiedOnParkingFull(){
        parkingLot.park(new Car(1213));
        assertEquals(true, testParkingLotOwner.full);
    }


    @org.junit.Test
    public void testOwnerNotifiedOnParkingNoMoreFull(){
        parkingLot.park(new Car(1213));
        parkingLot.unPark(2);
        parkingLot.unPark(1);
        assertEquals(false, testParkingLotOwner.full);
    }
}