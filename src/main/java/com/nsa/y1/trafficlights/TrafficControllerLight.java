package com.nsa.y1.trafficlights;

public class TrafficControllerLight {

    public TrafficControllerLight() {
        this.redLight = new Light(Shape.CIRCLE, Colour.RED);
        this.amberLight = new Light(Shape.CIRCLE, Colour.AMBER);
        this.greenLight = new Light(Shape.CIRCLE, Colour.GREEN);
        this.redLight.turnOn();
        this.amberLight.turnOff();
        this.greenLight.turnOff();
    }

    private Light redLight;
    private Light amberLight;
    private Light greenLight;

    public State getState() {
        if(redLight.isOn() == true && amberLight.isOn() == false) {
            return State.RED;
        } else if(redLight.isOn() == true && amberLight.isOn() == true) {
            return State.REDAMBER;
        } else if(greenLight.isOn() == true) {
            return State.GREEN;
        } else {
            return State.AMBER;
        }
    }

    public void sequenceStateOnce() {
        if(redLight.isOn() == true && amberLight.isOn() == false) {
            amberLight.turnOn();
        } else if(redLight.isOn() == true && amberLight.isOn() == true) {
            redLight.turnOff();
            amberLight.turnOff();
            greenLight.turnOn();
        } else if(greenLight.isOn() == true) {
            greenLight.turnOff();
            amberLight.turnOn();
        } else {
            amberLight.turnOff();
            redLight.turnOn();
        }
    }

    public void setState(State state) {
        if(state == State.RED) {
            redLight.turnOn();
            amberLight.turnOff();
            greenLight.turnOff();
        } else if(state == State.REDAMBER) {
            redLight.turnOn();
            amberLight.turnOn();
            greenLight.turnOff();
        } else if(state == State.GREEN) {
            redLight.turnOff();
            amberLight.turnOff();
            greenLight.turnOn();
        } else {
            redLight.turnOff();
            amberLight.turnOn();
            greenLight.turnOff();
        }
    }
}
