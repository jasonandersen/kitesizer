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

    @Test
    public void testFindWeight() {
        KiteSizeService target = new KiteSizeService();
        List<KiteSizeRecommendation> output;
        output = target.findWeightRange(95);
        assertNotNull(output);
        assertFalse(output.isEmpty());

        KiteSizeRecommendation first = output.get(0);
        assertEquals(3, first.getKiteSize());
        assertEquals(12, output.size());
    }

    @Test
    public void testFindWind15Knots() {
        KiteSizeService target = new KiteSizeService();
        KiteSizeRecommendation output = target.findWindRange(15, target.findWeightRange(95));
        assertNotNull(output);
        assertEquals(6, output.getKiteSize());
    }

    @Test
    public void testFindWind20Knots() {
        KiteSizeService target = new KiteSizeService();
        KiteSizeRecommendation output = target.findWindRange(20, target.findWeightRange(95));
        assertNotNull(output);
        assertEquals(4, output.getKiteSize());
    }

    @Test
    public void testFindWeight125() {
        KiteSizeService target = new KiteSizeService();
        List<KiteSizeRecommendation> output;
        output = target.findWeightRange(125);
        assertNotNull(output);
        assertFalse(output.isEmpty());

        KiteSizeRecommendation first = output.get(0);
        assertEquals(4, first.getKiteSize());
        assertEquals(12, output.size());
    }
}
