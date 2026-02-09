package models.parking;

import models.mobility.VehicleType;

import java.util.List;

public class ElectricBikeParkingSlot extends  ParkingSlot implements BikeSlot, ElectricSlot{

    public ElectricBikeParkingSlot(int slotNumber, ParkingFloor floor) {
        super(slotNumber, floor, List.of(VehicleType.ELECTRIC_BIKE));
    }

    @Override

    public void chargeVehicle() {
        System.out.println("Charging Electric Bike");
    }
}
