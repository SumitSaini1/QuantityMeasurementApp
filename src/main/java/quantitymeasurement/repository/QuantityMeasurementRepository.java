package quantitymeasurement.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import quantitymeasurement.model.QuantityMeasurementEntity;
public interface QuantityMeasurementRepository extends JpaRepository<QuantityMeasurementEntity,Long> {
    
}
