package ia.roadzen.platform.u20231b475.telemetry.application.internal.commandservices;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import ia.roadzen.platform.u20231b475.telemetry.application.internal.outboundservices.acl.ExternalFleetManagementService;
import ia.roadzen.platform.u20231b475.telemetry.domain.model.aggregates.TelemetryRecord;
import ia.roadzen.platform.u20231b475.telemetry.domain.model.commands.CreateTelemetryRecordCommand;
import ia.roadzen.platform.u20231b475.telemetry.domain.services.TelemetryRecordCommandService;
import ia.roadzen.platform.u20231b475.telemetry.infrastructure.persistence.jpa.repositories.TelemetryRecordRepository;

/**
 * Telemetry record command service implementation
 */
@Service
public class TelemetryRecordCommandServiceImpl implements TelemetryRecordCommandService {
  private final TelemetryRecordRepository repo;
  private final ExternalFleetManagementService service;
  private static final Logger LOGGER = LoggerFactory.getLogger(TelemetryRecordCommandServiceImpl.class);
  private final MessageSource messageSource;

  public TelemetryRecordCommandServiceImpl(TelemetryRecordRepository repo, ExternalFleetManagementService service,
      MessageSource messageSource) {
    this.repo = repo;
    this.service = service;
    this.messageSource = messageSource;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Optional<TelemetryRecord> handle(CreateTelemetryRecordCommand command) {
    boolean exists = service.existsVehicleByVin(command.vin());
    if (!exists) {
      LOGGER.error(messageSource.getMessage("vehicle.notExistsError", null, LocaleContextHolder.getLocale()));
    }

    var telemetryRecord = new TelemetryRecord(command);

    telemetryRecord.onRegistered();

    repo.save(telemetryRecord);

    return Optional.of(telemetryRecord);
  }
}
