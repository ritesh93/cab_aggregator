package com.ritesh.cab_aggregator_lld.service;

import com.ritesh.cab_aggregator_lld.exceptions.RiderAlreadyExistsException;
import com.ritesh.cab_aggregator_lld.model.Cab;
import com.ritesh.cab_aggregator_lld.model.Location;
import com.ritesh.cab_aggregator_lld.model.Rider;
import com.ritesh.cab_aggregator_lld.model.Trip;

import java.util.HashMap;
import java.util.Map;

public class RiderManagerService {
    Map<String, Rider> riderMap = new HashMap<>();

    public void registerRider(String riderId, String riderName){
        if(riderMap.containsKey(riderId)){
            throw new RiderAlreadyExistsException();
        }
        riderMap.put(riderId, new Rider(riderId, riderName));
    }

}
