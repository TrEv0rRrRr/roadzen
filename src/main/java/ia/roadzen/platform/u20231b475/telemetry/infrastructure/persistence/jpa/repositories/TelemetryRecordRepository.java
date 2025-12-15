package ia.roadzen.platform.u20231b475.telemetry.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ia.roadzen.platform.u20231b475.telemetry.domain.model.aggregates.TelemetryRecord;

/**
 * Represents the telemetry record repository.
 * Extends the Jpa Repository
 */
public interface TelemetryRecordRepository extends JpaRepository<TelemetryRecord, Long> {
}
