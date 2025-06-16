package com.thanhan.ecommerce.common.events;

public interface EventPublisher {

    void publish(DomainEvent event);
}
