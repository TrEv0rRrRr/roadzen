package ia.roadzen.platform.u20231b475.telemetry.interfaces.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ia.roadzen.platform.u20231b475.telemetry.domain.services.TelemetryRecordCommandService;
import ia.roadzen.platform.u20231b475.telemetry.interfaces.rest.resources.CreateTelemetryRecordResource;
import ia.roadzen.platform.u20231b475.telemetry.interfaces.rest.resources.TelemetryRecordResource;
import ia.roadzen.platform.u20231b475.telemetry.interfaces.rest.transform.CreateTelemetryRecordCommandFromResourceAssembler;
import ia.roadzen.platform.u20231b475.telemetry.interfaces.rest.transform.TelemetryRecordResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * The telemetry records controller
 */
@RestController
@RequestMapping(value = "/api/v1/telemetry-records")
@Tag(name = "TelemetryRecord controller", description = "Available telemetry records endpoints")
public class TelemetryRecordsController {
  private final TelemetryRecordCommandService service;

  public TelemetryRecordsController(TelemetryRecordCommandService service) {
    this.service = service;
  }

  /**
   * Create a new telemetry record
   * 
   * @param resource The {@link CreateTelemetryRecordResource} instance
   * @return The created {@link TelemetryRecordResource}
   */
  @PostMapping
  @Operation(summary = "Creates a new telemetry record")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "201", description = "Telemetry record created successfully!"),
      @ApiResponse(responseCode = "400", description = "Bad request")
  })
  public ResponseEntity<TelemetryRecordResource> createTelemetryRecord(
      @Valid @RequestBody CreateTelemetryRecordResource resource) {
    var createTelemetryRecordCommand = CreateTelemetryRecordCommandFromResourceAssembler
        .toCommandFromResource(resource);

    var telemetryRecord = service.handle(createTelemetryRecordCommand);

    if (telemetryRecord.isEmpty())
      return ResponseEntity.badRequest().build();

    var createdTelemetryRecord = telemetryRecord.get();

    var telemetryRecordResource = TelemetryRecordResourceFromEntityAssembler
        .toResourceFromEntity(createdTelemetryRecord);

    return new ResponseEntity<>(telemetryRecordResource, HttpStatus.CREATED);
  }
}
