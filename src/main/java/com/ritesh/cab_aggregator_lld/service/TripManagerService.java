package com.ritesh.cab_aggregator_lld.service;

import com.ritesh.cab_aggregator_lld.exceptions.NoCabFound;
import com.ritesh.cab_aggregator_lld.exceptions.NoRideHistoryFound;
import com.ritesh.cab_aggregator_lld.model.Cab;
import com.ritesh.cab_aggregator_lld.model.Location;
import com.ritesh.cab_aggregator_lld.model.Rider;
import com.ritesh.cab_aggregator_lld.model.Trip;
import com.ritesh.cab_aggregator_lld.strategy.CabMatchingStrategy;
import com.ritesh.cab_aggregator_lld.strategy.PriceStrategy;

import java.util.*;

public class TripManagerService {
    private static final double MAX_ALLOWED_DISTANCE = 10.0;
    Map<String, List<Trip>> tripMap = new HashMap<>();
    PriceStrategy priceStrategy;
    CabMatchingStrategy cabMatchingStrategy;
    CabManagerService cabManagerService;

    TripManagerService(PriceStrategy priceStrategy, CabMatchingStrategy cabMatchingStrategy, CabManagerService cabManagerService){
        this.cabMatchingStrategy = cabMatchingStrategy;
        this.priceStrategy = priceStrategy;
        this.cabManagerService = cabManagerService;
    }

    public List<Trip> fetchTripHistory(String riderId){
        if(!tripMap.containsKey(riderId)){
            throw new NoRideHistoryFound();
        }
        return tripMap.get(riderId);
    }

    public Trip createTrip(Rider rider, Location fromLocation, Location toLocation){
        List<Cab> cabList = cabManagerService.getCabs(fromLocation, MAX_ALLOWED_DISTANCE);
        Optional<Cab> cabOptional = cabMatchingStrategy.getCab(cabList);
        if(!cabOptional.isPresent()){
            throw new NoCabFound();
        }
        Cab selectedCab = cabOptional.get();
        double distance = fromLocation.distance(toLocation);
        double price = priceStrategy.getPrice(fromLocation, toLocation);
        Trip trip = new Trip(selectedCab, rider, fromLocation, toLocation, price);
        if(!tripMap.containsKey(rider.getId())){
            List<Trip> tripList = new ArrayList<>();
            tripMap.put(rider.getId(), tripList);
        }
        tripMap.get(rider.getId()).add(trip);
        return trip;
    }

    public void endTrip(Trip trip){
        trip.endTrip();
    }
}
