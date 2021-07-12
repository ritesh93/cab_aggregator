package com.ritesh.cab_aggregator_lld.strategy;

import com.ritesh.cab_aggregator_lld.model.Location;

public class DefaultPriceStrategy implements PriceStrategy {

    private static final int DISTANCE_RATE = 13;

    @Override
    public double getPrice(Location fromLocation, Location toLocation) {
        double distance = fromLocation.distance(toLocation);
        return distance * DISTANCE_RATE;
    }
}
