package com.sensiblemetrics.api.alpenidos.core.concurrent.sharedstate;

import com.sensiblemetrics.api.alpenidos.core.annotation.GuardedBy;
import com.sensiblemetrics.api.alpenidos.core.annotation.ThreadSafe;

/**
 * Pattern: Protected Shared State
 * <p>
 * Motivations: When you have a shared object passed through threads, you need
 * to protect it's internal state.
 * <p>
 * Intent: Guard the shared mutable state of the object with a lock using the
 * synchronized mechanism. Protect all paths that interacts with the object
 * state, creating a thread safe class. We do this to avoid hazards like race
 * conditions.
 * <p>
 * Applicability: Simples classes where you have a single independent mutable
 * variable(s).
 * <p>
 * Example: A simple counter class
 */
@ThreadSafe
public class ProtectedSharedState {

    @GuardedBy("this")
    private Object state;

    @GuardedBy("this")
    private Object state2;

    public synchronized Object getState() {
        return this.state;
    }

    public synchronized void setState(Object state) {
        this.state = state;
    }

    public synchronized Object getState2() {
        return this.state2;
    }

    public synchronized void setState2(Object state2) {
        this.state2 = state2;
    }
}
