package ia.roadzen.platform.u20231b475.telemetry.interfaces.rest.transform;

import ia.roadzen.platform.u20231b475.telemetry.domain.model.commands.CreateTelemetryRecordCommand;
import ia.roadzen.platform.u20231b475.telemetry.interfaces.rest.resources.CreateTelemetryRecordResource;

/**
 * Assembler class to convert a telemetry record command from a telemetry record
 * resource
 */
public class CreateTelemetryRecordCommandFromResourceAssembler {
  /**
   * Static method to convert a create telemetry record resource into a create
   * telemetry record command
   * 
   * @param resource The {@link CreateTelemetryRecordResource}
   * @return The {@link CreateTelemetryRecordCommand}
   */
  public static CreateTelemetryRecordCommand toCommandFromResource(CreateTelemetryRecordResource resource) {
    return new CreateTelemetryRecordCommand(resource.vehicleVin(), resource.batteryLevelPct(), resource.speedKmh(),
        resource.engineStatus(), resource.recordedAt());
  }
}
