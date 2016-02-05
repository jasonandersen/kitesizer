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

        ArrayList<KiteSizeRecommendation> recommendations = new ArrayList<KiteSizeRecommendation>();

        recommendations.add(new KiteSizeRecommendation(3, 34, 28));
        recommendations.add(new KiteSizeRecommendation(3, 28, 24));
        recommendations.add(new KiteSizeRecommendation(4, 24, 21));
        recommendations.add(new KiteSizeRecommendation(4, 21, 19));
        recommendations.add(new KiteSizeRecommendation(5, 19, 17));
        recommendations.add(new KiteSizeRecommendation(6, 17, 15));
        recommendations.add(new KiteSizeRecommendation(6, 15, 14));
        recommendations.add(new KiteSizeRecommendation(7, 14, 13));
        recommendations.add(new KiteSizeRecommendation(7, 13, 12));
        recommendations.add(new KiteSizeRecommendation(8, 12, 11));
        recommendations.add(new KiteSizeRecommendation(8, 11, 10));
        recommendations.add(new KiteSizeRecommendation(9, 10, 8));

        return recommendations;
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
