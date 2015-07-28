package model;

import model.FBIAgent;

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
    public void onVacancy() {
        full=false;
    }
}
