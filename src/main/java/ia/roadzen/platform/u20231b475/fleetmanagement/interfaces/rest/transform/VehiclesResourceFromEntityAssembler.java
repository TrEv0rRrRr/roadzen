package ia.roadzen.platform.u20231b475.fleetmanagement.interfaces.rest.transform;

import ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.aggregates.Vehicles;
import ia.roadzen.platform.u20231b475.fleetmanagement.interfaces.rest.resources.VehiclesResource;

/**
 * Assembler class to convert a vehicle resource from a vehicles entity
 */
public class VehiclesResourceFromEntityAssembler {
  /**
   * Static method to convert a vehicle entity to a vehicle resource
   * 
   * @param entity The {@link Vehicles} entity to convert from
   * @return The {@link VehiclesResource}
   */
  public static VehiclesResource toResourceFromEntity(Vehicles entity) {
    return new VehiclesResource(entity.getId(), entity.getVin(), entity.getFleetId(), entity.getPreferredMaxSpeedKmh());
  }
}
