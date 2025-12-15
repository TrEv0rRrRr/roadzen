package ia.roadzen.platform.u20231b475.telemetry.domain.model.events;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

/**
 * TelemetryRecordRegisteredEvent
 * Event that is emitted when a telemetry record is registered
 */
@Getter
public class TelemetryRecordRegisteredEvent extends ApplicationEvent {
  private String vehicleVin;
  private Double speedKmh;

  public TelemetryRecordRegisteredEvent(Object source, String vehicleVin, Double speedKmh) {
    super(source);
    this.vehicleVin = vehicleVin;
    this.speedKmh = speedKmh;
  }
}
