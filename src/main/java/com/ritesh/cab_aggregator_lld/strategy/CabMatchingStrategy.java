package com.ritesh.cab_aggregator_lld.strategy;

import com.ritesh.cab_aggregator_lld.model.Cab;

import java.util.List;
import java.util.Optional;

public interface CabMatchingStrategy {
    Optional<Cab> getCab(List<Cab> cabList);
}
