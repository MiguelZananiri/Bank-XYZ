package com.duoc.events;

import java.time.LocalDateTime;
import java.util.UUID;

public interface DomainEvent {
    
    UUID eventId();

    LocalDateTime occurredAt();
}
