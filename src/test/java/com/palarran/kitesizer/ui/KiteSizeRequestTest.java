package com.palarran.kitesizer.ui;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Testing the {@link KiteSizeRequest} class.
 */
public class KiteSizeRequestTest {

    private KiteSizeRequest request;

    @Test
    public void testTypicalCase() {
        init("95", "10");
        assertEquals("Your kite size should be 8 meters sq.", request.getResponseText());
    }

    @Test
    public void testWindIsTooLow() {
        init("95", "5");
        assertEquals("There is not enough wind to kite in, brah.", request.getResponseText());
    }

    @Test
    public void testWindIsTooHigh() {
        init("95", "35");
        assertEquals("Too much wind - stay on the beach.", request.getResponseText());
    }

    /**
     * Initialize the request object.
     * @param weight
     * @param windSpeed
     */
    private void init(String weight, String windSpeed) {
        request = new KiteSizeRequest(weight, windSpeed);
    }
}
