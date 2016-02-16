package com.palarran.kitesizer.ui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        assertTrue(request.isValid());
    }

    @Test
    public void testWindIsTooLow() {
        init("95", "5");
        assertEquals("There is not enough wind to kite in, brah.", request.getResponseText());
        assertFalse(request.isValid());
    }

    @Test
    public void testWindIsTooHigh() {
        init("95", "35");
        assertEquals("Too much wind - stay on the beach.", request.getResponseText());
        assertFalse(request.isValid());
    }

    @Test
    public void testWeightTooLow() {
        init("94", "15");
        assertFalse(request.isValid());
    }

    @Test
    public void testWeightTooHigh() {
        init("301", "15");
        assertFalse(request.isValid());
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
