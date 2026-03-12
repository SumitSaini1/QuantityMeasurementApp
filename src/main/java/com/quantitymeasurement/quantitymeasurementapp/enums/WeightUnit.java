package com.quantitymeasurement.quantitymeasurementapp.enums;
import com.quantitymeasurement.quantitymeasurementapp.util.IMeasurable;
public enum WeightUnit implements IMeasurable {

    KILOGRAM(1.0),
    GRAM(0.001),
    POUND(0.453592);

    private final double conversionFactor;

    WeightUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }
}