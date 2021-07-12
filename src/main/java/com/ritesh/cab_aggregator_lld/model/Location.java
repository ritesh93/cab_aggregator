package com.ritesh.cab_aggregator_lld.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Location {
    private double x;
    private double y;

    public double distance(Location fromLocation){
        return Math.sqrt(Math.pow(fromLocation.x - x, 2) + Math.pow(fromLocation.y - y, 2));
    }
}
