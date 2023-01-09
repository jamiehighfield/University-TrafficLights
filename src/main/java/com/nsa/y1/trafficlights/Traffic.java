package com.nsa.y1.trafficlights;

public class Traffic {

    //Main entry point for the program
    public static void main(String[] args) throws InterruptedException {
        //This code represents the 3-way junction by Queen's Building's & Station Terrace. There is an absence of filter lights used to represent the junction.
        //However, the implementation is fairly accurate.

        //Initial implementation of the classes 'Colour', 'Light', 'Shape' & 'State' are copyright Carl Jones.

        //The TrafficControllerFlow constructor mandates an ArrayList passed as an argument which contains all TrafficControllerLights which should be associated
        //with that TrafficControllerFlow. This can be done in-line as has been done below by using Arrays.asList(...).

        TrafficControllerFlow trafficControllerFlow1 = new TrafficControllerFlow();
        TrafficControllerLight trafficControllerLight1 = new TrafficControllerLight(); //Flow 1
        TrafficControllerLight trafficControllerLight2 = new TrafficControllerLight(); //Flow 1
        trafficControllerFlow1.addTrafficControllerLight(trafficControllerLight1);
        trafficControllerFlow1.addTrafficControllerLight(trafficControllerLight2);

        TrafficControllerFlow trafficControllerFlow2 = new TrafficControllerFlow();
        TrafficControllerLight trafficControllerLight3 = new TrafficControllerLight(); //Flow 2
        TrafficControllerLight trafficControllerLight4 = new TrafficControllerLight(); //Flow 2
        TrafficControllerLight trafficControllerLight5 = new TrafficControllerLight(); //Flow 2
        trafficControllerFlow2.addTrafficControllerLight(trafficControllerLight3);
        trafficControllerFlow2.addTrafficControllerLight(trafficControllerLight4);
        trafficControllerFlow2.addTrafficControllerLight(trafficControllerLight5);

        TrafficControllerFlow trafficControllerFlow3 = new TrafficControllerFlow();
        TrafficControllerLight trafficControllerLight6 = new TrafficControllerLight(); //Flow 3
        TrafficControllerLight trafficControllerLight7 = new TrafficControllerLight(); //Flow 3
        trafficControllerFlow3.addTrafficControllerLight(trafficControllerLight3); //From flow 2
        trafficControllerFlow3.addTrafficControllerLight(trafficControllerLight6);
        trafficControllerFlow3.addTrafficControllerLight(trafficControllerLight7);

        //The TrafficController constructor mandates an ArrayList passed as an argument which contains all TrafficControllerFlows which should be sequenced
        //with that TrafficController. This can be done in-line as has been done below by using Arrays.asList(...).

        TrafficController trafficController = new TrafficController();
        trafficController.addTrafficControllerFlow(trafficControllerFlow1);
        trafficController.addTrafficControllerFlow(trafficControllerFlow2);
        trafficController.addTrafficControllerFlow(trafficControllerFlow3);

        //runTrafficController(...) starts the TrafficController

        trafficController.runTrafficController(100, 5000); //number of times to iterate, time between changing (flow time) in milliseconds
    }
}
