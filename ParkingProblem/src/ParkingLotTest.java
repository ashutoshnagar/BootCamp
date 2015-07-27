import org.junit.Before;

import static org.junit.Assert.*;

public class ParkingLotTest {


    private ParkingLot parkingLot;
    private TestParkingLotOwner testParkingLotOwner;
    private TestFBIAgent agent1;
    private TestFBIAgent agent2;
    private TestFBIAgent agent3;

    @Before
    public void setUp()
    {
        testParkingLotOwner =new TestParkingLotOwner();
         agent1=new TestFBIAgent(1);
         agent2=new TestFBIAgent(2);
         agent3=new TestFBIAgent(3);

        parkingLot=new ParkingLot(testParkingLotOwner);
        parkingLot.register(agent1);
        parkingLot.register(agent3);
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

    @org.junit.Test
    public void testFBIAgentNotifiedOnParkingFull()

    {parkingLot.park(new Car(1213));

        assertEquals(true, agent1.full);
        assertEquals(true, agent3.full);
    }

    @org.junit.Test
    public void testFBIAgentNotifiedOnParkingFullAfterUnregisteringAgent()

    {   parkingLot.unRegister(agent3);
        parkingLot.register(agent2);
        parkingLot.park(new Car(1213));

        assertEquals(true, agent1.full);
        assertEquals(true,agent2.full);
        assertEquals(false, agent3.full);
    }


    @org.junit.Test
    public void testFBIAgentNotifiedOnNoMoreParkingFull()

    {   parkingLot.park(new Car(1213));
        parkingLot.unPark(2);
        assertEquals(false, agent1.full);
        assertEquals(false, agent3.full);
    }
    @org.junit.Test
    public void testFBIAgentNotifiedOnNoMoreParkingFullAfterUnregisteringAgent()

    {   parkingLot.unRegister(agent3);
        parkingLot.register(agent2);
        parkingLot.park(new Car( 1213));
        parkingLot.unPark(1);
        assertEquals(false, agent1.full);
        assertEquals(false,agent2.full);
    }


}