package com.palarran.kitesizer;

import org.junit.Test;

/**
 * Testing KiteSizeService Class
 */

public class KiteSizeServiceTest {

    private KiteSizeService target = new KiteSizeService();

    @Test(expected = BelowMinimumWindSpeedException.class)
    public void testBelowMinimumWindSpeed() {
        target.calculateKiteSize(95, 7);
    }

    @Test(expected = AboveMaximumWindSpeedException.class)
    public void testAboveMaximumWind() {
        target.calculateKiteSize(95, 35);
    }

    @Test(expected = BelowMinimumWeightException.class)
    public void testBelowMinimumWeight() {
        target.calculateKiteSize(94, 15);
    }

    @Test(expected = AboveMaximumWeightException.class)
    public void testAboveMaximumWeight() {
        target.calculateKiteSize(300, 15);
    }

}
