package ia.roadzen.platform.u20231b475.telemetry.domain.model.commands;

import java.time.LocalDateTime;

import ia.roadzen.platform.u20231b475.telemetry.domain.model.valueobjects.EngineStatus;

/**
 * Command to create a telemetry
 */
public record CreateTelemetryRecordCommand(String vin, Double batteryLevelPct, Double speedKmh,
        EngineStatus engineStatus,
        LocalDateTime recordedAt) {
}
