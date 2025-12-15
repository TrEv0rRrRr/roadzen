package ia.roadzen.platform.u20231b475.fleetmanagement.infrastructure.persistence.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.aggregates.Vehicles;
import ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.valueobjects.VehicleIdentificationNumber;

/**
 * Represents the vehicles repository
 * It extends the JpaRepository interface.
 * 
 * @author Valentino Solis
 */
@Repository
public interface VehiclesRepository extends JpaRepository<Vehicles, Long> {
  /**
   * Finds a vehicle by vin
   * 
   * @param vin The {@link VehicleIdentificationNumber}
   * @return The {@link Vehicles} entity, if found, otherwise empty
   */
  Optional<Vehicles> findVehicleByVin(VehicleIdentificationNumber vin);

  /**
   * Determines whether a vehicle exists by vin or not
   * 
   * @param vin The {@link VehicleIdentificationNumber}
   * @return True if the vehicle exists, otherwise false
   */
  boolean existsVehicleByVin(VehicleIdentificationNumber vin);
}
