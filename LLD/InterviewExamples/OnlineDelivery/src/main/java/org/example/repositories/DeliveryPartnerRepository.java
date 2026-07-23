package org.example.repositories;

import org.example.models.DeliveryPartner;

import java.util.ArrayList;
import java.util.List;

public class DeliveryPartnerRepository {

    List<DeliveryPartner> deliveryPartners;

    public DeliveryPartnerRepository() {
        this.deliveryPartners = new ArrayList<>();
    }
}
