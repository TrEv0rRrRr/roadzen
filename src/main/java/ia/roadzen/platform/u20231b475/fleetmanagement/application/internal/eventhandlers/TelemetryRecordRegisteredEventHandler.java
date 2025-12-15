package ia.roadzen.platform.u20231b475.fleetmanagement.application.internal.eventhandlers;

import org.springframework.context.MessageSource;
import org.springframework.context.event.EventListener;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.valueobjects.VehicleIdentificationNumber;
import ia.roadzen.platform.u20231b475.fleetmanagement.infrastructure.persistence.jpa.repositories.VehiclesRepository;
import ia.roadzen.platform.u20231b475.telemetry.domain.model.events.TelemetryRecordRegisteredEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This service handles the TelemetryRecordRegisteredEvent
 */
@Service
public class TelemetryRecordRegisteredEventHandler {
  private final VehiclesRepository repo;
  private static final Logger LOGGER = LoggerFactory.getLogger(TelemetryRecordRegisteredEventHandler.class);
  private final MessageSource messageSource;

  public TelemetryRecordRegisteredEventHandler(VehiclesRepository repo, MessageSource messageSource) {
    this.repo = repo;
    this.messageSource = messageSource;
  }

  /**
   * Updates the preferredMaxSpeedKmh if the speedKmh is greater.
   */
  @Transactional
  @EventListener
  public void on(TelemetryRecordRegisteredEvent event) {
    var vehicleOpt = repo.findVehicleByVin(new VehicleIdentificationNumber(event.getVehicleVin()));

    if (vehicleOpt.isEmpty())
      LOGGER.error(messageSource.getMessage("vehicle.notExistsError", null, LocaleContextHolder.getLocale()));

    var vehicle = vehicleOpt.get();

    if (event.getSpeedKmh() > vehicle.getPreferredMaxSpeedKmh())
      vehicle.setPreferredMaxSpeedKmh(event.getSpeedKmh());
  }
}
