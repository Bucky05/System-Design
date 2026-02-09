package models.parking;

import models.mobility.Vehicle;
import models.mobility.VehicleType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class ParkingSlot {

    private final List<VehicleType> supportedVehicleTypes;
    private ParkingSlotStatus status;
    private final int slotNumber;
    private ParkingFloor floor;
    private Optional<Vehicle> vehicle;


    public ParkingSlot(int slotNumber, ParkingFloor floor, List<VehicleType> supportedVehicleTypes) {
        this.status = ParkingSlotStatus.EMPTY;
        this.floor = floor;
        this.slotNumber = slotNumber;
        this.floor.addParkingSlot(this);
        this.supportedVehicleTypes = supportedVehicleTypes;
    }

    public ParkingFloor getFloor() {
        return floor;
    }

    public void setFloor(ParkingFloor floor) {
        this.floor = floor;
    }

    public int getSlotNumber() {
        return slotNumber;
    }



    public ParkingSlotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingSlotStatus status) {
        this.status = status;
    }

    public Optional<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        // check if vehicle is supported first

        this.vehicle = Optional.of(vehicle);
        this.status = ParkingSlotStatus.OCCUPIED;
        System.out.println("Vehicle type not supported, Supported vehicle types for this slot are: "+supportedVehicleTypes);
    }

    public void removeVehicle() {
        this.status = ParkingSlotStatus.EMPTY;
        this.vehicle = Optional.empty();
    }

    public List<VehicleType> getSupportedVehicleTypes() {
        return supportedVehicleTypes;
    }

    public boolean isSlotAvailable() {
        return this.status == ParkingSlotStatus.EMPTY;
    }

    public boolean isVehicleSupported(Vehicle vehicle) {
        return this.supportedVehicleTypes.contains(vehicle.getType());

    }

    public void display() {
        System.out.println("Slot Number: " + slotNumber);
        System.out.println("Slot Status: " + status );
        System.out.println("Supported Vehicle Types: "+ Arrays.toString(supportedVehicleTypes.toArray()));
        if(vehicle.isPresent()) {
            System.out.println("Parked Vehicle: "+ vehicle.get().getRegistrationNumber());
        }
    }
}
