package com.quantitymeasurement.quantitymeasurementapp.repository;

import java.util.List;
import com.quantitymeasurement.quantitymeasurementapp.model.QuantityMeasurementEntity;

public interface IQuantityMeasurementRepository {

    void save(QuantityMeasurementEntity entity);

    List<QuantityMeasurementEntity> getAllMeasurements();

}