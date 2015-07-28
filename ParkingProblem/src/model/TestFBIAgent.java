package model;

import model.FBIAgent;

public class TestFBIAgent implements ParkingLotObserver {
    public    boolean full=false;

    @Override
    public void onFull() {
        full=true;
    }

    @Override
    public void onVacancy() {
        full=false;
    }
}
