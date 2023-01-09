package com.nsa.y1.trafficlights;

import java.util.ArrayList;

public class TrafficControllerFlow {

    private ArrayList<TrafficControllerLight> trafficControllerLights = new ArrayList<TrafficControllerLight>();

    public void addTrafficControllerLight(TrafficControllerLight trafficControllerLight) {
        trafficControllerLights.add(trafficControllerLight);
    }

    public State getState() {
        return trafficControllerLights.get(0).getState();
    }

    public void sequenceTrafficFlow() throws InterruptedException {
        for (int i = 0; i < trafficControllerLights.size(); i++) {
            trafficControllerLights.get(i).sequenceStateOnce();
        }
        System.out.println(trafficControllerLights.get(0).getState());
        Thread.sleep(1150);
        for (int i = 0; i < trafficControllerLights.size(); i++) {
            trafficControllerLights.get(i).sequenceStateOnce();
        }
        System.out.println(trafficControllerLights.get(0).getState());
        System.out.println("------------------");
    }

    public void setTrafficFlowState(State state) {
        for (int i = 0; i < trafficControllerLights.size(); i++) {
            trafficControllerLights.get(i).setState(state);
        }
    }

    public int getTrafficControllerLightCount() {
        return trafficControllerLights.size();
    }
}