package com.ritesh.cab_aggregator_lld.strategy;

import com.ritesh.cab_aggregator_lld.model.Cab;

import java.util.List;
import java.util.Optional;

public class DefaultCabMatchingStrategy implements CabMatchingStrategy {
    @Override
    public Optional<Cab> getCab(List<Cab> cabList) {
        return cabList.stream().filter(cab -> cab.getCurrentTrip() == null).findAny();
    }
}
