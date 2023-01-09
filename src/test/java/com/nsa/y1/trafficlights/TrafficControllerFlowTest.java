package com.nsa.y1.trafficlights;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrafficControllerFlowTest {

    private TrafficControllerFlow trafficControllerFlow;

    @Before
    public void createTrafficControllerFlows() {
        trafficControllerFlow = new TrafficControllerFlow();
        trafficControllerFlow.addTrafficControllerLight(new TrafficControllerLight());
    }

    @Test
    public void initialTrafficControllerFlowState() {
        assertEquals(trafficControllerFlow.getState(), State.RED);
    }

    @Test
    public void sequenceTrafficControllerFlowOnce() throws InterruptedException {
        trafficControllerFlow.sequenceTrafficFlow();
        assertEquals(trafficControllerFlow.getState(), State.GREEN);
    }

    @Test
    public void setTrafficControllerState() {
        trafficControllerFlow.setTrafficFlowState(State.REDAMBER);
        assertEquals(trafficControllerFlow.getState(), State.REDAMBER);
    }

    @Test
    public void trafficControllerLightCount() {
        assertEquals(trafficControllerFlow.getTrafficControllerLightCount(), 1);
    }
}
