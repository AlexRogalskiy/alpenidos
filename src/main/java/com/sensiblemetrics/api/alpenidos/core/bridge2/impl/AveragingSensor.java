package com.sensiblemetrics.api.alpenidos.core.bridge2.impl;

import com.sensiblemetrics.api.alpenidos.core.bridge2.exception.SensorException;
import com.sensiblemetrics.api.alpenidos.core.bridge2.iface.AveragingSensorIF;

public class AveragingSensor extends SimpleSensor {

    public AveragingSensor(final AveragingSensorIF sensor) {
        super(sensor);
    }

    public void beginAverage() throws SensorException {
        ((AveragingSensorIF) this.getSensorIF()).beginAverage();
    }
}
