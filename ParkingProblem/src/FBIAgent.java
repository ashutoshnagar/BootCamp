public class FBIAgent implements ParkingLotObserver {
    private int no;

    public int getNo() {
        return no;
    }

    public FBIAgent(int no){
        this.no=no;
    }
    public void onFull(){

    }

    public void onNoMoreFull() {
    }
}
