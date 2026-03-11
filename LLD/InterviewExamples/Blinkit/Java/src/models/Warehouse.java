package models;

import java.util.UUID;
public class Warehouse {

    private String id;
    private String city;

    public Warehouse(String city) {
        id = UUID.randomUUID().toString();
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public String getId() {
        return id;
    }
}
