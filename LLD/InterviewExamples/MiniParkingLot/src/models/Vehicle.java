package models;

public abstract class Vehicle {

    private final int vehicleNumber;
    private final int sizeOfVehicle;

    public Vehicle(int vehicleNumber, int sizeOfVehicle) {
        this.vehicleNumber = vehicleNumber;
        this.sizeOfVehicle = sizeOfVehicle;
    }

    public int getVehicleNumber() {
        return this.vehicleNumber;
    }

    public int getSizeOfVehicle() {
        return this.sizeOfVehicle;
    }
}
