package com.ritesh.cab_aggregator_lld.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Trip {
    Location fromLocation;
    Location toLocation;
    Rider rider;
    Cab cab;
    @Setter
    TripStatus status;
    double price;

     public Trip(Cab cab, Rider rider, Location fromLocation, Location toLocation, double price) {
        this.cab = cab;
        this.rider = rider;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        status = TripStatus.IN_PROGRESS;
    }

    public void endTrip() {
        this.status = TripStatus.END;
    }
}

enum TripStatus {
    IN_PROGRESS,
    END;
}
