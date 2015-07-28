package model;

import model.ParkingLotOwner;

public class TestParkingLotOwner extends ParkingLotOwner {
   public boolean full=false;
    @Override
    public void onFull() {
      full=true;
    }
    public void onVacancy() {
        full=false;
    }
}
