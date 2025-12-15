package ia.roadzen.platform.u20231b475.telemetry.interfaces.rest.transform;

import ia.roadzen.platform.u20231b475.telemetry.domain.model.aggregates.TelemetryRecord;
import ia.roadzen.platform.u20231b475.telemetry.interfaces.rest.resources.TelemetryRecordResource;

/**
 * Assembler class to convert a telemetry record to a telemetry record resource
 */
public class TelemetryRecordResourceFromEntityAssembler {
  /**
   * Converts a telemetry entity into a telemetry record resource
   * 
   * @param entity The {@link TelemetryRecord} entity to convert from
   * @return The {@link TelemetryRecordResource}
   */
  public static TelemetryRecordResource toResourceFromEntity(TelemetryRecord entity) {
    return new TelemetryRecordResource(entity.getId(), entity.getVehicleVin(), entity.getBatteryLevelPct(),
        entity.getSpeedKmh(), entity.getEngineStatus(), entity.getRecordedAt());
  }
}
