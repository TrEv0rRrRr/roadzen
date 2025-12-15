package ia.roadzen.platform.u20231b475.telemetry.interfaces.rest.resources;

import java.time.LocalDateTime;

import ia.roadzen.platform.u20231b475.telemetry.domain.model.valueobjects.EngineStatus;
import ia.roadzen.platform.u20231b475.telemetry.domain.model.valueobjects.VehicleIdentificationNumber;

/**
 * Represents a telemetry record resource
 */
public record TelemetryRecordResource(Long id, VehicleIdentificationNumber vehicleVin, Double batteryLevelPct, Double speedKmh,
    EngineStatus engineStatus, LocalDateTime recordedAt) {

}
