package ia.roadzen.platform.u20231b475.fleetmanagement.domain.model.valueobjects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * This VO represents the vehicle identification number
 * 
 * @author Valentino Solis
 */
@Embeddable
public record VehicleIdentificationNumber(
        @NotBlank(message = "{vin.required}") @Pattern(regexp = "^[A-Za-z]{2}-[A-Za-z]{3}-[A-Za-z0-9]{4}$", message = "{vin.invalidFormat}") String vin) {
}
