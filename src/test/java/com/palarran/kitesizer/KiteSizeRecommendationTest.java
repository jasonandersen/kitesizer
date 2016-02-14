package com.palarran.kitesizer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Testing the KiteSizeRecommendation class.
 */
public class KiteSizeRecommendationTest {

    @Test
    public void testWeightMidRange() {
        KiteSizeRecommendation rec = new KiteSizeRecommendation(999, 999, 999, 200, 100);
        assertTrue(rec.weightMatches(150));
    }

    @Test
    public void testWeightLessThanLowerBoundary() {
        KiteSizeRecommendation rec = new KiteSizeRecommendation(999, 999, 999, 200, 100);
        assertFalse(rec.weightMatches(99));
    }

    @Test
    public void testWeightEqualsLowerBoundary() {
        KiteSizeRecommendation rec = new KiteSizeRecommendation(999, 999, 999, 200, 100);
        assertTrue(rec.weightMatches(100));
    }

    @Test
    public void testWeightEqualsUpperBoundary() {
        KiteSizeRecommendation rec = new KiteSizeRecommendation(999, 999, 999, 200, 100);
        assertFalse(rec.weightMatches(200));
    }

    @Test
    public void testWeightGreaterThanUpperBoundary() {
        KiteSizeRecommendation rec = new KiteSizeRecommendation(999, 999, 999, 200, 100);
        assertFalse(rec.weightMatches(201));
    }

    @Test
    public void testWindMidRange() {
        KiteSizeRecommendation rec = new KiteSizeRecommendation(999, 20, 10, 999, 999);
        assertTrue(rec.windMatches(15));
    }

    @Test
    public void testWindLessThanLowerBoundary() {
        KiteSizeRecommendation rec = new KiteSizeRecommendation(999, 20, 10, 999, 999);
        assertFalse(rec.windMatches(9));
    }

    @Test
    public void testWindEqualsLowerBoundary() {
        KiteSizeRecommendation rec = new KiteSizeRecommendation(999, 20, 10, 999, 999);
        assertTrue(rec.windMatches(10));
    }

    @Test
    public void testWindEqualsUpperBoundary() {
        KiteSizeRecommendation rec = new KiteSizeRecommendation(999, 20, 10, 999, 999);
        assertFalse(rec.windMatches(20));
    }

    @Test
    public void testWindGreaterThanUpperBoundary() {
        KiteSizeRecommendation rec = new KiteSizeRecommendation(999, 20, 10, 999, 999);
        assertFalse(rec.windMatches(21));
    }

}
