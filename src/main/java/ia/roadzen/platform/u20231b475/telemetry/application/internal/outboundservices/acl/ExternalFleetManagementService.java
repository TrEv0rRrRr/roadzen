package ia.roadzen.platform.u20231b475.telemetry.application.internal.outboundservices.acl;

import org.springframework.stereotype.Service;

import ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.valueobjects.VehicleIdentificationNumber;
import ia.roadzen.platform.u20231b475.fleetmanagement.interfaces.acl.FleetManagementContextFacade;

/**
 * ExternalFleetManagementService
 * It receives external data from another bounded context through the ACL
 */
@Service
public class ExternalFleetManagementService {
  private final FleetManagementContextFacade facade;

  public ExternalFleetManagementService(FleetManagementContextFacade facade) {
    this.facade = facade;
  }

  /**
   * Determines whether a vehicle exists by vin or not
   * 
   * @param vin The {@link VehicleIdentificationNumber}
   * @return True if the vehicle exists, otherwise false
   */
  public boolean existsVehicleByVin(String vin) {
    return facade.existsVehicleByVin(vin);
  }
}
