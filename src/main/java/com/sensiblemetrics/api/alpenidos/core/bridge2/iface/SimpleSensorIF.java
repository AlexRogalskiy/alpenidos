package com.sensiblemetrics.api.alpenidos.core.bridge2.iface;

import com.sensiblemetrics.api.alpenidos.core.bridge2.SensorException;

public interface SimpleSensorIF {

    int getValue() throws SensorException;
}
