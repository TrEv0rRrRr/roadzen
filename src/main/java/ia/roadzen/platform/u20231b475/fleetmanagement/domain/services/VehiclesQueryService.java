package ia.roadzen.platform.u20231b475.fleetmanagement.domain.services;

import java.util.List;
import java.util.Optional;

import ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.aggregates.Vehicles;
import ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.queries.GetAllVehiclesQuery;
import ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.queries.GetVehicleByVinQuery;

/**
 * Represents the vehicles query service
 * 
 * @author Valentino Solis
 */
public interface VehiclesQueryService {
  /**
   * Handles the get all vehicles query
   * 
   * @param query The {@link GetAllVehiclesQuery}
   * @return A list of vehicles
   */
  List<Vehicles> handle(GetAllVehiclesQuery query);

  /**
   * Handles the get vehicle by vin
   * 
   * @param query The {@link GetVehicleByVinQuery}
   * @return An {@link Optional} of {@link Vehicles}
   */
  Optional<Vehicles> handle(GetVehicleByVinQuery query);
}
