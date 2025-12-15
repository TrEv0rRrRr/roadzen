package ia.roadzen.platform.u20231b475.fleetmanagement.interfaces.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.queries.GetAllVehiclesQuery;
import ia.roadzen.platform.u20231b475.fleetmanagement.domain.services.VehiclesQueryService;
import ia.roadzen.platform.u20231b475.fleetmanagement.interfaces.rest.resources.VehiclesResource;
import ia.roadzen.platform.u20231b475.fleetmanagement.interfaces.rest.transform.VehiclesResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Vehicles Controller
 */
@RestController
@RequestMapping(value = "/api/v1/vehicles")
@Tag(name = "Vehicles controller", description = "Available vehicles controller")
public class VehiclesController {
  private final VehiclesQueryService service;

  public VehiclesController(VehiclesQueryService service) {
    this.service = service;
  }

  /**
   * Get all available vehicles
   * 
   * @return A list of available {@link VehiclesResource}
   */
  @GetMapping
  @Operation(summary = "Get all vehicles")
  @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Vehicles found"),
      @ApiResponse(responseCode = "404", description = "Vehicles not found") })
  public ResponseEntity<List<VehiclesResource>> getAllVehicles() {
    var vehicles = service.handle(new GetAllVehiclesQuery());

    if (vehicles.isEmpty())
      return ResponseEntity.notFound().build();

    var vehiclesResource = vehicles.stream().map(VehiclesResourceFromEntityAssembler::toResourceFromEntity).toList();

    return ResponseEntity.ok(vehiclesResource);
  }
}
