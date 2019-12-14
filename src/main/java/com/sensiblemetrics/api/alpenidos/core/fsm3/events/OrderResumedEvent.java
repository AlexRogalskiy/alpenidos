package com.sensiblemetrics.api.alpenidos.core.fsm3.events;

import com.sensiblemetrics.api.alpenidos.core.fsm3.OrderIdentifier;
import com.sensiblemetrics.api.alpenidos.core.fsm3.OrderStatus;

public class OrderResumedEvent extends AbstractOrderEvent {

    private static final long serialVersionUID = 1L;

    public OrderResumedEvent(OrderIdentifier identifier, OrderStatus oldStatus, OrderStatus newStatus) {
        super(identifier, oldStatus, newStatus);
    }
}