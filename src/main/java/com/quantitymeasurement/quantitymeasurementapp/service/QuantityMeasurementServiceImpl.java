package com.quantitymeasurement.quantitymeasurementapp.service;

import com.quantitymeasurement.quantitymeasurementapp.util.IMeasurable;
import com.quantitymeasurement.quantitymeasurementapp.util.Quantity;

public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    @Override
    public <U extends IMeasurable> Quantity<U> add(
            Quantity<U> q1,
            Quantity<U> q2,
            U targetUnit) {

        return q1.add(q2, targetUnit);
    }

    @Override
    public <U extends IMeasurable> Quantity<U> subtract(
            Quantity<U> q1,
            Quantity<U> q2,
            U targetUnit) {

        return q1.subtract(q2, targetUnit);
    }

    @Override
    public <U extends IMeasurable> Quantity<U> convert(
            Quantity<U> quantity,
            U targetUnit) {

        return quantity.convertTo(targetUnit);
    }

    @Override
    public <U extends IMeasurable> boolean compare(
            Quantity<U> q1,
            Quantity<U> q2) {

        return q1.equals(q2);
    }

    @Override
    public <U extends IMeasurable> double divide(
            Quantity<U> q1,
            Quantity<U> q2) {

        return q1.divide(q2);
    }
}