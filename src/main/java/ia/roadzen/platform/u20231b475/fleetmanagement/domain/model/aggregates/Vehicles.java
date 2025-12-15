package ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.aggregates;

import ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.valueobjects.VehicleIdentificationNumber;
import ia.roadzen.platform.u20231b475.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * The vehicles aggregate root
 * 
 * @author Valentino Solis
 */
@Entity
@Getter
public class Vehicles extends AuditableAbstractAggregateRoot<Vehicles> {
  @Embedded
  private VehicleIdentificationNumber vin;

  @NotNull(message = "{fleetId.required}")
  @Min(value = 1, message = "{fleetId.positive}")
  private Long fleetId;

  @NotNull(message = "{preferredMaxSpeedKmh.required}")
  @Min(value = 80, message = "{preferredMaxSpeedKmh.minValueError}")
  @Max(value = 130, message = "{preferredMaxSpeedKmh.maxValueError}")
  @Setter
  private Double preferredMaxSpeedKmh;

  public Vehicles() {
  } // Empty for JPA

  public Vehicles(String vin, Long fleetId, Double preferredMaxSpeedKmh) {
    this.vin = new VehicleIdentificationNumber(vin);
    this.fleetId = fleetId;
    this.preferredMaxSpeedKmh = preferredMaxSpeedKmh;
  }
}
