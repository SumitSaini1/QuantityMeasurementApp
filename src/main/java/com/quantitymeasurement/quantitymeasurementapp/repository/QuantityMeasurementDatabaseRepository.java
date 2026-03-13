package com.quantitymeasurement.quantitymeasurementapp.repository;

import com.quantitymeasurement.quantitymeasurementapp.model.QuantityMeasurementEntity;
import com.quantitymeasurement.quantitymeasurementapp.util.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuantityMeasurementDatabaseRepository implements IQuantityMeasurementRepository {

    @Override
    public void save(QuantityMeasurementEntity entity) {

        String sql = "INSERT INTO quantity_measurement_entity(operation,result_value,result_unit) VALUES (?,?,?)";

        try (Connection conn = ConnectionPool.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, entity.operation);
            stmt.setDouble(2, entity.resultValue);
            stmt.setString(3, entity.resultUnit);

            stmt.executeUpdate();
            System.out.println("Saved to database: "
                    + entity.operation + " "
                    + entity.resultValue + " "
                    + entity.resultUnit);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<QuantityMeasurementEntity> getAllMeasurements() {

        List<QuantityMeasurementEntity> list = new ArrayList<>();

        String sql = "SELECT operation, result_value, result_unit FROM quantity_measurement_entity";

        try (Connection conn = ConnectionPool.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                QuantityMeasurementEntity entity = new QuantityMeasurementEntity();
                entity.operation = rs.getString("operation");
                entity.resultValue = rs.getDouble("result_value");
                entity.resultUnit = rs.getString("result_unit");

                list.add(entity);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}