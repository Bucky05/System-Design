package models.tickets;


import models.mobility.Vehicle;
import models.parking.ParkingSlot;
import models.payments.PaymentStrategy;
import models.pricing.PricingStrategy;
import services.PricingService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Ticket {
    private String id;
    private Long entryTime;
    private Optional<Long> exitTime;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;
    private List<PricingStrategy> pricingStrategyList;
    private Optional<PaymentStrategy> paymentStrategy;

    public Ticket(Long entryTime, Vehicle vehicle, ParkingSlot parkingSlot, List<PricingStrategy> pricingStrategyList) {
        this.id = UUID.randomUUID().toString();
        this.entryTime = entryTime;
        this.vehicle = vehicle;
        this.parkingSlot = parkingSlot;
        this.pricingStrategyList = pricingStrategyList;
    }

    public void setExitTime(Long exitTime) {
        this.exitTime = Optional.of(exitTime);
    }

    public String getId() {
        return id;
    }

    public Optional<PaymentStrategy> getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(Optional<PaymentStrategy> paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void calculateAndPay() {

        long price = PricingService.calculateParkingCharge(this);
        paymentStrategy.get().pay(price);

    }

    public Long getEntryTime() {
        return entryTime;
    }

    public List<PricingStrategy> getPricingStrategyList() {
        return this.pricingStrategyList;
    }

    public Optional<Long> getExitTime() {
        return exitTime;
    }

    public void display() {
        System.out.println("Ticket ID: "+ this.id);

        System.out.println("Entry Time: " + this.entryTime);
        System.out.println("Vehicle: "+ this.vehicle.getRegistrationNumber());
        System.out.println("Parking Slot: "+this.parkingSlot.getSlotNumber());
    }
}

