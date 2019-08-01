package com.sensiblemetrics.api.alpenidos.core.object_pool.impl;

import com.sensiblemetrics.api.alpenidos.core.object_pool.iface.Resource;
import com.sensiblemetrics.api.alpenidos.core.object_pool.iface.ResourceFactory;

public class RealResourceFactory implements ResourceFactory {

    @Override
    public Resource get() {
        return new RealResource();
    }
}
