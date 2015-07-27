public class TestParkingLotOwner extends ParkingLotOwner {
    boolean full=false;
    @Override
    public void onFull() {
      full=true;
    }
    public void onNoMoreFull() {
        full=false;
    }
}
