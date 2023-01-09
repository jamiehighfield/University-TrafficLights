package com.nsa.y1.trafficlights;

import java.util.ArrayList;

public class TrafficController {

    private ArrayList<TrafficControllerFlow> trafficControllerFlows = new ArrayList<TrafficControllerFlow>();

    private int currentState = 0;

    public void addTrafficControllerFlow(TrafficControllerFlow trafficControllerFlow) {
        trafficControllerFlows.add(trafficControllerFlow);
        trafficControllerFlows.get(0).setTrafficFlowState(State.GREEN);
    }

    private void sequenceTrafficController() throws InterruptedException {
        System.out.println("FLOW " + (currentState + 1));
        System.out.println("------------------");
        trafficControllerFlows.get(currentState).sequenceTrafficFlow();
        if(currentState == trafficControllerFlows.size() - 1) {
            System.out.println("FLOW 1");
            System.out.println("------------------");
            trafficControllerFlows.get(0).sequenceTrafficFlow();
            currentState = 0;
        } else {
            System.out.println("FLOW " + (currentState + 2));
            System.out.println("------------------");
            trafficControllerFlows.get(currentState + 1).sequenceTrafficFlow();
            currentState += 1;
        }
    }

    public void runTrafficController(int count, int flowTime) throws InterruptedException {
        for(int i = 0; i < count; i++) {
            sequenceTrafficController();
            Thread.sleep(flowTime);
        }
    }

    public void runTrafficControllerOnce() throws InterruptedException {
        sequenceTrafficController();
    }


    public int getTrafficControllerFlowCount() {
        return trafficControllerFlows.size();
    }
}
