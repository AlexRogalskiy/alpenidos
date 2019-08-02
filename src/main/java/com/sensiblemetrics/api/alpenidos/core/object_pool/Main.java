package com.sensiblemetrics.api.alpenidos.core.object_pool;

import com.sensiblemetrics.api.alpenidos.core.object_pool.iface.Resource;
import com.sensiblemetrics.api.alpenidos.core.object_pool.iface.ResourceFactory;
import com.sensiblemetrics.api.alpenidos.core.object_pool.impl.RealResourceFactory;

public class Main {
    public static void main(String[] args) {
        ResourceFactory factory = new ResourcePoolFactory(new RealResourceFactory());

        Resource resource1 = factory.get();
        Resource resource2 = factory.get();
        Resource resource3 = factory.get();

        resource1.print();
        resource2.print();
        resource3.print();

        System.out.println();

        resource3.close();
        resource2.close();

        Resource resource4 = factory.get(); //resource3
        Resource resource5 = factory.get(); //resource2

        resource4.print();
        resource5.print();

    }
}