package ia.roadzen.platform.u20231b475.fleetmanagement.application.internal.eventhandlers;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.valueobjects.VehicleIdentificationNumber;
import ia.roadzen.platform.u20231b475.fleetmanagement.infrastructure.persistence.jpa.repositories.VehiclesRepository;
import ia.roadzen.platform.u20231b475.shared.application.i18n.MessageResolver;
import ia.roadzen.platform.u20231b475.telemetry.domain.model.events.TelemetryRecordRegisteredEvent;

/**
 * This service handles the TelemetryRecordRegisteredEvent
 */
@Service
public class TelemetryRecordRegisteredEventHandler {
  private final VehiclesRepository repo;
  private final MessageResolver messageResolver;

  public TelemetryRecordRegisteredEventHandler(VehiclesRepository repo, MessageResolver messageResolver) {
    this.repo = repo;
    this.messageResolver = messageResolver;
  }

  /**
   * Updates the preferredMaxSpeedKmh if the speedKmh is greater.
   */
  @Transactional
  @EventListener
  public void on(TelemetryRecordRegisteredEvent event) {
    var vehicleOpt = repo.findVehicleByVin(new VehicleIdentificationNumber(event.getVehicleVin()));

    if (vehicleOpt.isEmpty())
      throw new IllegalArgumentException(messageResolver.resolve("vehicle.notExistsError"));

    var vehicle = vehicleOpt.get();

    if (event.getSpeedKmh() > vehicle.getPreferredMaxSpeedKmh())
      vehicle.setPreferredMaxSpeedKmh(event.getSpeedKmh());
  }
}
