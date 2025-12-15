package ia.roadzen.platform.u20231b475.telemetry.interfaces.rest.resources;

import java.time.LocalDateTime;

import ia.roadzen.platform.u20231b475.telemetry.domain.model.valueobjects.EngineStatus;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

/**
 * Represents the resource to create a telemetry record
 */
public record CreateTelemetryRecordResource(
                @NotBlank(message = "{vin.required}") @Pattern(regexp = "^[A-Za-z]{2}-[A-Za-z]{3}-[A-Za-z0-9]{4}$", message = "{vin.invalidFormat}") String vehicleVin,
                @NotNull(message = "{batteryLevelPct.required}") @Min(value = 0, message = "{batteryLevelPct.minValueError}") @Max(value = 100, message = "{batteryLevelPct.maxValueError}") Double batteryLevelPct,
                @NotNull(message = "{speedKmh.required}") @Min(value = 0, message = "{speedKmh.minValueError}") Double speedKmh,
                EngineStatus engineStatus,
                @NotNull(message = "{recordedAt.required}") @PastOrPresent(message = "{recordedDate.futureDateError}") LocalDateTime recordedAt) {

}
