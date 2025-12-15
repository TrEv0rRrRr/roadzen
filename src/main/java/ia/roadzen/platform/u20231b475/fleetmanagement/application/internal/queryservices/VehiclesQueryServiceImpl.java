package ia.roadzen.platform.u20231b475.fleetmanagement.application.internal.queryservices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.aggregates.Vehicles;
import ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.queries.GetAllVehiclesQuery;
import ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.queries.GetVehicleByVinQuery;
import ia.roadzen.platform.u20231b475.fleetmanagement.domain.services.VehiclesQueryService;
import ia.roadzen.platform.u20231b475.fleetmanagement.infrastructure.persistence.jpa.repositories.VehiclesRepository;

/**
 * Represents the vehicles query service implementation
 * 
 * @author Valentino Solis
 */
@Service
public class VehiclesQueryServiceImpl implements VehiclesQueryService {
  private final VehiclesRepository repo;

  public VehiclesQueryServiceImpl(VehiclesRepository repo) {
    this.repo = repo;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Vehicles> handle(GetAllVehiclesQuery query) {
    return repo.findAll();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Optional<Vehicles> handle(GetVehicleByVinQuery query) {
    return repo.findVehicleByVin(query.vin());
  }
}
