public class TestFBIAgent extends FBIAgent {
public    boolean full=false;
    public TestFBIAgent(int no){
        super(no);

    }
    @Override
    public void onFull() {
        full=true;
    }

    @Override
    public void onNoMoreFull() {
        full=false;
    }
}
