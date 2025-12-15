package ia.roadzen.platform.u20231b475.fleetmanagement.interfaces.rest.resources;

import ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.valueobjects.VehicleIdentificationNumber;

/**
 * Represents the vehicle resource
 * 
 * @author Valentino Solis
 */
public record VehiclesResource(Long id, VehicleIdentificationNumber vin, Long fleetId, Double preferredMaxSpeedKmh) {
}
