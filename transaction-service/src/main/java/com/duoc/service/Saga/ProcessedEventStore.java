package com.duoc.service.Saga;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class ProcessedEventStore {

    private final Set<UUID> processedEvent = 
        ConcurrentHashMap.newKeySet();
        
    public boolean isFirstTime(UUID eventId) {
        return processedEvent.add(eventId);
    }
    
}
