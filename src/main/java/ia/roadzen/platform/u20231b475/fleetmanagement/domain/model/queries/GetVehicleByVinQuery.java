package ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.queries;

import ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.valueobjects.VehicleIdentificationNumber;

/**
 * Retrieve a vehicle by it's vin
 */
public record GetVehicleByVinQuery(VehicleIdentificationNumber vin) {
}
