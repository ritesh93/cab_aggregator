package com.ritesh.cab_aggregator_lld.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class Cab {
    private String id;
    private String driverName;

    @Setter
    private Location currentLocation;
    @Setter
    private boolean isAvailable;
    @Setter
    private Trip currentTrip;

    public Cab(String id, String driverName){
        this.id = id;
        this.driverName = driverName;
        this.isAvailable = true;
    }
}
