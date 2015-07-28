package model;

import model.ParkingLotOwner;

public class TestParkingLotOwner implements ParkingLotObserver {
   public boolean full=false;
    @Override
    public void onFull() {
      full=true;
    }
    public void onVacancy() {
        full=false;
    }
}
