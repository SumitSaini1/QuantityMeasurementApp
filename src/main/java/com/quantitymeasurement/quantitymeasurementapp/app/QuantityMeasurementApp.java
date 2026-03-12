package com.quantitymeasurement.quantitymeasurementapp.app;

import com.quantitymeasurement.quantitymeasurementapp.controller.QuantityMeasurementController;
import com.quantitymeasurement.quantitymeasurementapp.util.IMeasurable;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        QuantityMeasurementController controller =
                new QuantityMeasurementController();

        controller.startApplication();
    }

    public static double convert(double value,
                                 IMeasurable source,
                                 IMeasurable target) {

        if (source == null || target == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }

        double baseValue = source.convertToBaseUnit(value);

        return target.convertFromBaseUnit(baseValue);
    }
}