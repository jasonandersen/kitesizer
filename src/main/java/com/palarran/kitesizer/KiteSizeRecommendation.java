package com.palarran.kitesizer;

/**
 * Recommendation for a kite size based on weight and wind speed.
 */
public class KiteSizeRecommendation {

    private final int kiteSize;
    private final int upperWindSpeed;
    private final int lowerWindSpeed;
    private final int lowerWeight;
    private final int upperWeight;

    /**
     * Constructor.
     */
    public KiteSizeRecommendation(int kiteSize, int upperSpeed, int lowerSpeed, int upperWeight, int lowerWeight) {
        this.kiteSize = kiteSize;
        this.upperWindSpeed = upperSpeed;
        this.lowerWindSpeed = lowerSpeed;
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
        return upperWindSpeed;
    }

    /**
     * @return lower wind speed boundary in knots
     */
    public int getLowerWindSpeed() {
        return lowerWindSpeed;
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

    /**
     * @param weight
     * @return true if this weight value is inside the boundaries of this recommendation
     */
    public boolean weightMatches(double weight) {
        return weight >= lowerWeight && weight < upperWeight;
    }

    /**
     * @param windSpeed
     * @return true if this wind value is inside the boundaries of this recommendation
     */
    public boolean windMatches(int windSpeed) {
        return windSpeed >= lowerWindSpeed && windSpeed < upperWindSpeed;
    }

}
