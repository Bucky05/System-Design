package models.mobility;

public class ElectricBike  extends  Vehicle implements ElectricVehicle{

    public ElectricBike(String registrationNumber, String color) {
        super(registrationNumber,color,VehicleType.ELECTRIC_BIKE);
    }

    @Override
    public void charge() {
        System.out.println("Charging Electric Bike");
    }

    @Override
    public float getBatteryPercent() {
        return 0f;
    }
}
