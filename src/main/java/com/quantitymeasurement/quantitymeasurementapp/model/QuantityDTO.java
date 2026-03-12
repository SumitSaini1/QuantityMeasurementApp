package com.quantitymeasurement.quantitymeasurementapp.model;

import com.quantitymeasurement.quantitymeasurementapp.util.IMeasurable;

public class QuantityDTO {

    public double value;
    public IMeasurable unit;

    public QuantityDTO(double value, IMeasurable unit) {
        this.value = value;
        this.unit = unit;
    }
}