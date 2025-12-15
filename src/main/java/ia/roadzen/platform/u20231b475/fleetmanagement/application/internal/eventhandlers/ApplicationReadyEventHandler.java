package ia.roadzen.platform.u20231b475.fleetmanagement.application.internal.eventhandlers;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.commands.SeedVehiclesCommand;
import ia.roadzen.platform.u20231b475.fleetmanagement.domain.services.VehiclesCommandService;

/**
 * ApplicationReadyEventHandler class
 * This class is used to handle the ApplicationReadyEvent
 */
@Service
public class ApplicationReadyEventHandler {
  private final VehiclesCommandService service;

  public ApplicationReadyEventHandler(VehiclesCommandService service) {
    this.service = service;
  }

  /**
   * Handle the ApplicationReadyEvent
   * This method is used to seed the vehicles table
   * 
   * @param event the ApplicationReadyEvent the event to handle
   */
  @EventListener
  public void on(ApplicationReadyEvent event) {
    var seedVehiclesCommand = new SeedVehiclesCommand();

    service.handle(seedVehiclesCommand);
  }
}
