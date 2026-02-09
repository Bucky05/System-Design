package models.parking;

import models.mobility.VehicleType;

import java.util.List;

public class CarParkingSlot extends ParkingSlot implements CarSlot{

    private String carNumber;

    public CarParkingSlot(int slotNumber, ParkingFloor floor) {
        super(slotNumber, floor, List.of(VehicleType.CAR, VehicleType.BIKE));
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }
}
