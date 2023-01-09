package com.nsa.y1.trafficlights;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;


/**
 * Test the basic operation of a light.
 */
public class LightTest {

    private Light redCircleLight;
    private Light amberCircleLight;
    private Light greenRightLight;

    @Before
    public void createLights() throws Exception {
        redCircleLight = new Light(); //test default constructor
        amberCircleLight = new Light(Shape.CIRCLE, Colour.AMBER);
        greenRightLight = new Light(Shape.RIGHT_ARROW, Colour.GREEN);
    }

    @Test
    public void defaultLightIsRedAndCircular() throws Exception {
        Light testRedCircleLight = new Light(Shape.CIRCLE, Colour.RED);
        assertEquals(redCircleLight, testRedCircleLight);
    }

    @Test
    public void gettersReturnFields() throws Exception {
        assertEquals(Colour.GREEN, greenRightLight.getColour());
        assertEquals(Shape.RIGHT_ARROW, greenRightLight.getShape());
        assertFalse(greenRightLight.isOn());
    }

    @Test
    public void toStringIsCorrect() {
        assertEquals("Light{theShape=CIRCLE, theColour=AMBER, isOn=false}", amberCircleLight.toString());
    }

    @Test
    public void trafficLightInitialState() {
        TrafficControllerLight trafficControllerLight = new TrafficControllerLight();
        assertEquals(trafficControllerLight.getState(), State.RED);
    }

    @Test
    public void trafficLightSequence() {
        TrafficControllerLight trafficControllerLight = new TrafficControllerLight();
        trafficControllerLight.sequenceStateOnce();
        assertEquals(trafficControllerLight.getState(), State.REDAMBER);
    }
}
