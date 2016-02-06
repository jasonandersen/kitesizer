package com.palarran.kitesizer;

import java.util.ArrayList;
import java.util.List;

/**
 * Service that calculates kite sizes.
 */
public class KiteSizeService {

    /**
     * @param weight
     * @param windSpeed
     * @return a calculated kite size based on weight and wind speed
     */
    public int calculateKiteSize(double weight, int windSpeed) {

        /*
         * find the right weight range, price is right rules
         * 
         * find the right wind range, price is right rules
         * 
         * get the wind speed at that location
         */

        List<KiteSizeRecommendation> recommendations = new ArrayList<KiteSizeRecommendation>();
        recommendations = findWeightRange(weight);
        KiteSizeRecommendation finalRecommendation = findWindRange(windSpeed, recommendations);

        return finalRecommendation.getKiteSize();
    }

    /**
     * @param weight
     * @return a list of kite size recommendations for my weight range
     */
    protected List<KiteSizeRecommendation> findWeightRange(double weight) {

        /*
         * 1. Fetch all 144 KiteSizeRecommendations
         * 2. Find all KiteSizeRecommendations in the user's weight range
         * 3. Return just the KiteSizeRecommendations for the user's weight range
         */

    }

    /**
     * @param windSpeed
     * @param recommendations
     * @return a single recommendation based on wind range
     */
    protected KiteSizeRecommendation findWindRange(int windSpeed, List<KiteSizeRecommendation> recommendations) {

        /*
         * loop through each recommendation in recommendations
         * if windSpeed argument matches recommendation wind speed
         *      return that recommendation
         */

        for (KiteSizeRecommendation recommendation : recommendations) {
            if (windSpeed <= recommendation.getUpperWindSpeed() && windSpeed > recommendation.getLowerWindSpeed()) {
                return recommendation;
            }
        }

        return new KiteSizeRecommendation(999, 999, 999);
    }

}
