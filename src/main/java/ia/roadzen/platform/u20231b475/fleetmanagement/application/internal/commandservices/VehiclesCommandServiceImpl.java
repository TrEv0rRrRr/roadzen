package ia.roadzen.platform.u20231b475.fleetmanagement.application.internal.commandservices;

import java.util.List;

import org.springframework.stereotype.Service;

import ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.aggregates.Vehicles;
import ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.commands.SeedVehiclesCommand;
import ia.roadzen.platform.u20231b475.fleetmanagement.domain.services.VehiclesCommandService;
import ia.roadzen.platform.u20231b475.fleetmanagement.infrastructure.persistence.jpa.repositories.VehiclesRepository;

/**
 * Represents the vehicles command service implementation
 * 
 * @author Valentino Solis
 */
@Service
public class VehiclesCommandServiceImpl implements VehiclesCommandService {
  private final VehiclesRepository repo;

  public VehiclesCommandServiceImpl(VehiclesRepository repo) {
    this.repo = repo;
  }

  /**
   * Handle the seed vehicles command. It will create the entities inside of the
   * table.
   */
  @Override
  public void handle(SeedVehiclesCommand command) {
    if (repo.count() > 0)
      return;

    repo.saveAll(List.of(
        new Vehicles("RZ-TES-M201", Long.valueOf(101), 100.0),
        new Vehicles("RZ-NIO-X342", Long.valueOf(102), 120.0),
        new Vehicles("RZ-BYD-S550", Long.valueOf(101), 90.0),
        new Vehicles("RZ-BMW-E678", Long.valueOf(103), 110.0)));
  }
}
