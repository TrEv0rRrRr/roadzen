package ia.roadzen.platform.u20231b475.telemetry.domain.services;

import java.util.Optional;

import ia.roadzen.platform.u20231b475.telemetry.domain.model.aggregates.TelemetryRecord;
import ia.roadzen.platform.u20231b475.telemetry.domain.model.commands.CreateTelemetryRecordCommand;

/**
 * Represents the telemetry command service
 */
public interface TelemetryRecordCommandService {
  /**
   * Handles the create telemetry record command
   * 
   * @param command The {@link CreateTelemetryRecordCommand}
   */
  Optional<TelemetryRecord> handle(CreateTelemetryRecordCommand command);
}
