package ia.roadzen.platform.u20231b475.fleetmanagement.domain.services;

import ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.commands.SeedVehiclesCommand;

/**
 * Represents the vehicles command service
 * 
 * @author Valentino Solis
 */
public interface VehiclesCommandService {
  /**
   * Handles the seed vehicles command
   * 
   * @param command The {@link SeedVehiclesCommand}
   */
  void handle(SeedVehiclesCommand command);
}
