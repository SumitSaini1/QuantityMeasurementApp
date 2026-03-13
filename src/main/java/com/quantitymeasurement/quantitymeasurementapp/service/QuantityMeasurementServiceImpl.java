package com.quantitymeasurement.quantitymeasurementapp.service;

import com.quantitymeasurement.quantitymeasurementapp.model.QuantityMeasurementEntity;
import com.quantitymeasurement.quantitymeasurementapp.repository.IQuantityMeasurementRepository;
import com.quantitymeasurement.quantitymeasurementapp.util.IMeasurable;
import com.quantitymeasurement.quantitymeasurementapp.util.Quantity;

public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService {

    private final IQuantityMeasurementRepository repository;

    public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository) {
        this.repository = repository;
    }

    @Override
        public <U extends IMeasurable> Quantity<U> add(
                Quantity<U> q1,
                Quantity<U> q2,
                U targetUnit) {
        
            Quantity<U> result = q1.add(q2, targetUnit);
        
            QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
            entity.operation = "ADD";
            entity.resultValue = result.getValue();
            entity.resultUnit = result.getUnit().toString();
        
            repository.save(entity);
        
            return result;
        }

        @Override
        public <U extends IMeasurable> Quantity<U> subtract(
                Quantity<U> q1,
                Quantity<U> q2,
                U targetUnit) {
        
            Quantity<U> result = q1.subtract(q2, targetUnit);
        
            QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
            entity.operation = "SUBTRACT";
            entity.resultValue = result.getValue();
            entity.resultUnit = result.getUnit().toString();
        
            repository.save(entity);
        
            return result;
        }

        @Override
        public <U extends IMeasurable> Quantity<U> convert(
                Quantity<U> quantity,
                U targetUnit) {
        
            Quantity<U> result = quantity.convertTo(targetUnit);
        
            QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
            entity.operation = "CONVERT";
            entity.resultValue = result.getValue();
            entity.resultUnit = result.getUnit().toString();
        
            repository.save(entity);
        
            return result;
        }

        @Override
        public <U extends IMeasurable> boolean compare(
                Quantity<U> q1,
                Quantity<U> q2) {
        
            boolean result = q1.equals(q2);
        
            QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
            entity.operation = "COMPARE";
            entity.resultValue = result ? 1 : 0;
            entity.resultUnit = "BOOLEAN";
        
            repository.save(entity);
        
            return result;
        }

        @Override
        public <U extends IMeasurable> double divide(
                Quantity<U> q1,
                Quantity<U> q2) {
        
            double result = q1.divide(q2);
        
            QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
            entity.operation = "DIVIDE";
            entity.resultValue = result;
            entity.resultUnit = "RATIO";
        
            repository.save(entity);
        
            return result;
        }
}