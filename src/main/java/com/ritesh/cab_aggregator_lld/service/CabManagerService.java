package com.ritesh.cab_aggregator_lld.service;

import com.ritesh.cab_aggregator_lld.exceptions.CabAlreadyExistsException;
import com.ritesh.cab_aggregator_lld.exceptions.CabNotExistException;
import com.ritesh.cab_aggregator_lld.model.Cab;
import com.ritesh.cab_aggregator_lld.model.Location;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CabManagerService {
    Map<String, Cab> cabs = new HashMap<String, Cab>();

    public void createCab(String cabId, String driverName) {
        if (cabs.containsKey(cabId)) {
            throw new CabAlreadyExistsException();
        }
        cabs.put(cabId, new Cab(cabId, driverName));
    }

    public List<Cab> getCabs(final Location fromLocation, double limit) {
        List<Cab> cabList = cabs.values().stream().filter(cab -> cab.getCurrentLocation().distance(fromLocation) < limit).collect(Collectors.toList());
        return cabList;
    }

    public void updateCabAvailibility(String cabId, boolean isAvailable) {
        if (!cabs.containsKey(cabId)) {
            throw new CabNotExistException();
        }
        cabs.get(cabId).setAvailable(isAvailable);
    }

    public void updateCabLocation(String cabId, Location location) {
        if (!cabs.containsKey(cabId)) {
            throw new CabNotExistException();
        }
        cabs.get(cabId).setCurrentLocation(location);
    }
}
