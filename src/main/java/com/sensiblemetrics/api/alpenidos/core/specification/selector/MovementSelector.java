package com.sensiblemetrics.api.alpenidos.core.specification.selector;

import com.sensiblemetrics.api.alpenidos.core.specification.model.iface.Creature;
import com.sensiblemetrics.api.alpenidos.core.specification.property.Movement;
import lombok.RequiredArgsConstructor;

import java.util.function.Predicate;

/**
 * Movement selector.
 */
@RequiredArgsConstructor
public class MovementSelector implements Predicate<Creature> {
    private final Movement m;

    @Override
    public boolean test(final Creature t) {
        return t.getMovement().equals(this.m);
    }
}
