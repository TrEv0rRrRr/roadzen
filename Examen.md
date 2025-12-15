# Bounded Contexts

## Vehicles

- Bounded context: **fleet-management**
- Auditable, por ende tiene los atributos `createdAt` y `updatedAt`

### Atributos

- `id` (Long, Primary Key, Autogenerado)
- `vin` (Vehicle Identification Number, obligatorio)
- `fleetId` (Long, obligatorio, positivo)
- `preferredMaxSpeedKmh` (Double, obligatorio)

### Nota

- [x] La información de Vehicles **debe poblarse automáticamente al iniciar la aplicación** mediante el evento ApplicationReadyEvent.

| `id` | `vin`       | `fleetId` | `preferredMaxSpeedKmh` |
| ---- | ----------- | --------- | ---------------------- |
| 1    | RZ-TES-M201 | 101       | 100.0                  |
| 2    | RZ-NIO-X342 | 102       | 120.0                  |
| 3    | RZ-BYD-S550 | 101       | 90.0                   |
| 4    | RZ-BMW-E678 | 103       | 110.0                  |

## TelemetryRecord

- Bounded context: **telemetry**
- Auditable, por ende tiene los atributos `createdAt` y `updatedAt`

### Atributos

- `id` (Long, Primary Key, Autogenerado)
- `vehicleVin` (VIN, obligatorio),
- `batteryLevelPct` (Double, obligatorio)
- `speedKmh` (Double, obligatorio, ≥ 0.0),
- `engineStatus` (EngineStatus, obligatorio)
- `recordedAt` (LocalDateTime, obligatorio, no nulo).

#### EngineStatus enum

| `id` | `Name` |
| ---- | ------ |
| 0    | ON     |
| 1    | OFF    |
| 2    | ERROR  |

### Nota

Al registrar un `TelemetryRecord` con datos válidos, se debe validar que `vehicleVin` exista en Vehicles, y de emitir un evento de integración `TelemetryRecordRegisteredEvent`, que incluya `vehicleVin` y `speedKmh`.

# Business Rules

## Vehicles

- [x] `vin` es un VO, formato válido: 2 letras + guion + 3 letras + guion + 4 caracteres alfanuméricos, ej. "RZ-TES-M201"
- [x] `preferredMaxSpeedKmh` debe estar entre 80.0 y 130.0

## TelemetryRecord

- [x] `vehicleVin` debe corresponder a un Vehicle existente
- [x] `batteryLevelPct` debe estar entre 0.0 y 100.0
- [x] `recordedAt` no puede ser posterior a la fecha actual y se proporciona en la request con el formato "yyyy-MM-dd HH:mm:ss"
- [x] Los valores de `engineStatus` se envían como String en el request

# Event Handlers

## TelemetryRecordRegisteredEvent

Debe actualizar `preferredMaxSpeedKmh` del Vehicle correspondiente **solo si** el nuevo `speedKmh` supera el valor actual.

# Endpoints

## Telemetry records endpoint `(/api/v1/telemetry-records)`

- Implementar una operación `POST`
- Retornar un `201`
- Devolver en la response el id autogenerado y los demás atributos, **menos los de auditoría**

## Vehicles endpoint `(/api/v1/vehicles)`

- Implementar una operación `GET`
- Retornar un `200`
- Devolver la lista de vehículos **sin atributos de auditoría**
