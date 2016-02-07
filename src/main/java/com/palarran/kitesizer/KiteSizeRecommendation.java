package com.palarran.kitesizer;

/**
 * Recommendation for a kite size based on weight and wind speed.
 */
public class KiteSizeRecommendation {

    private final int kiteSize;
    private final int upperSpeed;
    private final int lowerSpeed;
    private final int lowerWeight;
    private final int upperWeight;

    /**
     * Constructor.
     */
    public KiteSizeRecommendation(int kiteSize, int upperSpeed, int lowerSpeed, int upperWeight, int lowerWeight) {
        this.kiteSize = kiteSize;
        this.upperSpeed = upperSpeed;
        this.lowerSpeed = lowerSpeed;
        this.upperWeight = upperWeight;
        this.lowerWeight = lowerWeight;
    }

    /**
     * @return The final kite size will be returned. This based on given user weight and wind speed. The kite size "number" is how large 
     * the kite is in square meters.
     */
    public int getKiteSize() {
        return kiteSize;
    }

    /**
     * @return upper wind speed boundary in knots
     */
    public int getUpperWindSpeed() {
        return upperSpeed;
    }

    /**
     * @return lower wind speed boundary in knots
     */
    public int getLowerWindSpeed() {
        return lowerSpeed;
    }

    /**
     * @return lower weight boundary in pounds
     */
    public int getLowerWeight() {
        return lowerWeight;
    }

    /**
     * @return upper weight boundary in pounds
     */
    public int getUpperWeight() {
        return upperWeight;
    }

}
