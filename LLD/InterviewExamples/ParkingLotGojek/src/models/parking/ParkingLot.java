package models.parking;

import models.pricing.PricingStrategy;
import services.ParkingLotService;

import java.util.List;

public class ParkingLot {

    private List<ParkingFloor> floors;
    private ParkingLotService parkingLotService;
    private List<PricingStrategy> pricingStrategyList;
    public ParkingLot(List<ParkingFloor> floors, List<PricingStrategy> pricingStrategyList) {
        this.floors = floors;
        this.pricingStrategyList = pricingStrategyList;
    }

    public void addParkingFloor(ParkingFloor parkingFloor) {
        this.floors.add(parkingFloor);
    }

    public void removeParkingFloor(ParkingFloor parkingFloor) {
        this.floors.remove(parkingFloor);
    }

    public List<ParkingFloor> getFloors() {
        return this.floors;
    }

    public List<PricingStrategy> getPricingStrategyList() {
        return this.pricingStrategyList;
    }


}
