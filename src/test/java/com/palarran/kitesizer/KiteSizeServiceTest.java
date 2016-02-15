package com.palarran.kitesizer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

/**
 * Testing KiteSizeService Class
 */

public class KiteSizeServiceTest {

    private KiteSizeService target = new KiteSizeService();

    @Test
    public void testFindWeight() {
        List<KiteSizeRecommendation> output = target.findWeightRange(95);
        assertNotNull(output);
        assertFalse(output.isEmpty());

        KiteSizeRecommendation first = output.get(0);
        assertEquals(3, first.getKiteSize());
        assertEquals(12, output.size());
    }

    @Test
    public void testFindWind15Knots() {
        KiteSizeRecommendation output = target.findWindRange(15, target.findWeightRange(95));
        assertNotNull(output);
        assertEquals(6, output.getKiteSize());
    }

    @Test
    public void testFindWind20Knots() {
        KiteSizeRecommendation output = target.findWindRange(20, target.findWeightRange(95));
        assertNotNull(output);
        assertEquals(4, output.getKiteSize());
    }

    @Test
    public void testFindWeight125() {
        List<KiteSizeRecommendation> output = target.findWeightRange(125);
        assertNotNull(output);
        assertFalse(output.isEmpty());

        KiteSizeRecommendation first = output.get(0);
        assertEquals(4, first.getKiteSize());
        assertEquals(12, output.size());
    }

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
