package ia.roadzen.platform.u20231b475.fleetmanagement.interfaces.acl;

import ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.valueobjects.VehicleIdentificationNumber;

/**
 * The fleet management context facade
 * It is used to send data from this context to another
 */
public interface FleetManagementContextFacade {
  /**
   * Determines whether a vehicle exists by vin or not
   * 
   * @param vin The {@link VehicleIdentificationNumber}
   * @return True if the vehicle exists, otherwise false
   */
  boolean existsVehicleByVin(String vin);

  /**
   * Updates the preferred max speed kmh
   * 
   * @param vin                  The {@link VehicleIdentificationNumber}
   * @param preferredMaxSpeedKmh The PreferredMaxSpeedKmh
   */
  // void updatePreferredMaxSpeedKmh(String vin, Double preferredMaxSpeedKmh);
}
