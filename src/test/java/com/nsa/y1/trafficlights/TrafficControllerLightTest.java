package com.nsa.y1.trafficlights;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrafficControllerLightTest {

    private TrafficControllerLight trafficControllerLight;

    @Before
    public void createTrafficControllerLights() {
        trafficControllerLight = new TrafficControllerLight();
    }

    @Test
    public void initialTrafficControllerLightTest() {
        assertEquals(trafficControllerLight.getState(), State.RED);
    }

    @Test
    public void setTrafficControllerLightState() {
        trafficControllerLight.sequenceStateOnce();
        assertEquals(trafficControllerLight.getState(), State.REDAMBER);
        trafficControllerLight.sequenceStateOnce();
        assertEquals(trafficControllerLight.getState(), State.GREEN);
        trafficControllerLight.setState(State.GREEN);
        assertEquals(trafficControllerLight.getState(), State.GREEN);
    }
}
