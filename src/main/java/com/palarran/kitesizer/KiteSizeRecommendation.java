package com.palarran.kitesizer;

/**
 * Recommendation for a kite size based on weight and wind speed.
 */
public class KiteSizeRecommendation {

    private int size = 0;
    private int upperSpeed = 0;
    private int lowerSpeed = 0;

    /**
     * @param i
     */
    public KiteSizeRecommendation(int size, int upperSpeed, int lowerSpeed) {
        this.size = size;
        this.upperSpeed = upperSpeed;
        this.lowerSpeed = lowerSpeed;
    }

    /**
     * @return The final kite size will be returned. This based on given user weight and wind speed. The kite size "number" is how large 
     * the kite is in square meters.
     */
    public int getKiteSize() {
        return size;
    }

    /**
     * @return windspeed value in Knots
     */
    public int getUpperWindSpeed() {
        return upperSpeed;
    }

    public int getLowerWindSpeed() {
        return lowerSpeed;
    }

}
