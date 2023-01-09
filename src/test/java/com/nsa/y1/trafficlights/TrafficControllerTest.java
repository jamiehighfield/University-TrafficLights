package com.nsa.y1.trafficlights;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TrafficControllerTest {

    private TrafficController trafficController;
    private TrafficControllerFlow trafficControllerFlow1;
    private TrafficControllerFlow trafficControllerFlow2;
    private TrafficControllerLight trafficControllerLight1;
    private TrafficControllerLight trafficControllerLight2;
    private TrafficControllerLight trafficControllerLight3;
    private TrafficControllerLight trafficControllerLight4;


    @Before
    public void createTrafficControllers() {
        trafficControllerFlow1 = new TrafficControllerFlow();
        trafficControllerLight1 = new TrafficControllerLight(); //Flow 1
        trafficControllerLight2 = new TrafficControllerLight(); //Flow 1
        trafficControllerFlow1.addTrafficControllerLight(trafficControllerLight1);
        trafficControllerFlow1.addTrafficControllerLight(trafficControllerLight2);

        trafficControllerFlow2 = new TrafficControllerFlow();
        trafficControllerLight3 = new TrafficControllerLight(); //Flow 2
        trafficControllerLight4 = new TrafficControllerLight(); //Flow 2
        trafficControllerFlow2.addTrafficControllerLight(trafficControllerLight3);
        trafficControllerFlow2.addTrafficControllerLight(trafficControllerLight4);

        trafficController = new TrafficController();
        trafficController.addTrafficControllerFlow(trafficControllerFlow1);
        trafficController.addTrafficControllerFlow(trafficControllerFlow2);
    }

    @Test
    public void checkDefaultStates() {
        assertEquals(true, (trafficControllerFlow1.getState() == State.GREEN && trafficControllerFlow2.getState() == State.RED) ? true : false);
    }

    @Test
    public void sequenceState() throws InterruptedException {
        trafficController.runTrafficControllerOnce();
        assertEquals(true, (trafficControllerFlow1.getState() == State.RED && trafficControllerFlow2.getState() == State.GREEN) ? true : false);
    }

    @Test
    public void trafficControllerFlowCount() {
        trafficController.addTrafficControllerFlow(new TrafficControllerFlow());
        assertEquals(trafficController.getTrafficControllerFlowCount(), 3);
    }
}
