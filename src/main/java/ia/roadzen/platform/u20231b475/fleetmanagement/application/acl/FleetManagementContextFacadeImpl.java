package ia.roadzen.platform.u20231b475.fleetmanagement.application.acl;

import org.springframework.stereotype.Service;

import ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.valueobjects.VehicleIdentificationNumber;
import ia.roadzen.platform.u20231b475.fleetmanagement.infrastructure.persistence.jpa.repositories.VehiclesRepository;
import ia.roadzen.platform.u20231b475.fleetmanagement.interfaces.acl.FleetManagementContextFacade;

/**
 * Implements the FleetManagementContextFacade interface
 */
@Service
public class FleetManagementContextFacadeImpl implements FleetManagementContextFacade {
  private final VehiclesRepository repo;

  public FleetManagementContextFacadeImpl(VehiclesRepository repo) {
    this.repo = repo;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean existsVehicleByVin(String vin) {
    return repo.existsVehicleByVin(new VehicleIdentificationNumber(vin));
  }

  /**
   * {@inheritDoc}
   */
  // @Override
  // public void updatePreferredMaxSpeedKmh(String vin, Double
  // preferredMaxSpeedKmh) {
  // }
}
