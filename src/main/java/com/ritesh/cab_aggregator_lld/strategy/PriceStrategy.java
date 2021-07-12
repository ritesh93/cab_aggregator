package com.ritesh.cab_aggregator_lld.strategy;

import com.ritesh.cab_aggregator_lld.model.Location;

public interface PriceStrategy {
    double getPrice(Location fromLocation, Location toLocation);
}
