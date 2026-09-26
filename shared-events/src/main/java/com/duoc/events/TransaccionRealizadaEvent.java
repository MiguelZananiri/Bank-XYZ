package com.duoc.events;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record TransaccionRealizadaEvent(
    UUID eventId,
    LocalDateTime occurredAt,
    Long cuentaId,
    BigDecimal monto,
    String tipo
) implements DomainEvent {
    
}
