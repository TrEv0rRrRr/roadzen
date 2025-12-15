package ia.roadzen.platform.u20231b475.telemetry.application.internal.commandservices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ia.roadzen.platform.u20231b475.shared.application.i18n.MessageResolver;
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
  private final MessageResolver messageResolver;

  public TelemetryRecordCommandServiceImpl(TelemetryRecordRepository repo, ExternalFleetManagementService service,
      MessageResolver messageResolver) {
    this.repo = repo;
    this.service = service;
    this.messageResolver = messageResolver;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Optional<TelemetryRecord> handle(CreateTelemetryRecordCommand command) {
    boolean exists = service.existsVehicleByVin(command.vin());
    if (!exists) {
      throw new IllegalArgumentException(messageResolver.resolve("vehicle.notExistsError"));
    }

    var telemetryRecord = new TelemetryRecord(command);

    telemetryRecord.onRegistered();

    repo.save(telemetryRecord);

    return Optional.of(telemetryRecord);
  }
}
