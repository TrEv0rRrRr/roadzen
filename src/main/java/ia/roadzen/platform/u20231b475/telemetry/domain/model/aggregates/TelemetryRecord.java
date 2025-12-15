package ia.roadzen.platform.u20231b475.telemetry.domain.model.aggregates;

import java.time.LocalDateTime;

import ia.roadzen.platform.u20231b475.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import ia.roadzen.platform.u20231b475.telemetry.domain.model.commands.CreateTelemetryRecordCommand;
import ia.roadzen.platform.u20231b475.telemetry.domain.model.events.TelemetryRecordRegisteredEvent;
import ia.roadzen.platform.u20231b475.telemetry.domain.model.valueobjects.EngineStatus;
import ia.roadzen.platform.u20231b475.telemetry.domain.model.valueobjects.VehicleIdentificationNumber;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Getter;

/**
 * The telemetry aggregate root
 */
@Entity
@Getter
public class TelemetryRecord extends AuditableAbstractAggregateRoot<TelemetryRecord> {
  @Embedded
  private VehicleIdentificationNumber vehicleVin;

  @NotNull(message = "{batteryLevelPct.required}")
  @Min(value = 0, message = "{batteryLevelPct.minValueError}")
  @Max(value = 100, message = "{batteryLevelPct.maxValueError}")
  private Double batteryLevelPct;

  @NotNull(message = "{speedKmh.required}")
  @Min(value = 0, message = "{speedKmh.minValueError}")
  private Double speedKmh;

  @Enumerated(EnumType.STRING)
  private EngineStatus engineStatus;

  @NotNull(message = "{recordedAt.required}")
  @PastOrPresent(message = "{recordedDate.futureDateError}")
  private LocalDateTime recordedAt;

  public TelemetryRecord() {
  } // Empty for JPA

  public TelemetryRecord(CreateTelemetryRecordCommand command) {
    this.vehicleVin = new VehicleIdentificationNumber(command.vin());
    this.batteryLevelPct = command.batteryLevelPct();
    this.speedKmh = command.speedKmh();
    this.engineStatus = command.engineStatus();
    this.recordedAt = command.recordedAt();
  }

  public void onRegistered() {
    this.registerEvent(new TelemetryRecordRegisteredEvent(this, vehicleVin.vin(), speedKmh));
  }
}
