package quantitymeasurement.service;

import quantitymeasurement.util.Quantity;
import quantitymeasurement.util.IMeasurable;

public interface IQuantityMeasurementService {

    Quantity<?> add(
            Quantity<?> q1,
            Quantity<?> q2,
            IMeasurable targetUnit);

    Quantity<?> subtract(
            Quantity<?> q1,
            Quantity<?> q2,
            IMeasurable targetUnit);

    Quantity<?> convert(
            Quantity<?> quantity,
            IMeasurable targetUnit);

    boolean compare(
            Quantity<?> q1,
            Quantity<?> q2);

    double divide(
            Quantity<?> q1,
            Quantity<?> q2);
}