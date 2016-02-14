package com.palarran.kitesizer;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service that calculates kite sizes.
 */
public class KiteSizeService {

    private static Logger log = LoggerFactory.getLogger(KiteSizeService.class);

    private KiteSizeDAO dao = new KiteSizeDAO();

    /**
     * @param weight
     * @param windSpeed
     * @return a calculated kite size based on weight and wind speed
     */
    public int calculateKiteSize(double weight, int windSpeed) {
        log.info("Calculating kite size for weight of {} and wind speed of {}.", weight, windSpeed);
        List<KiteSizeRecommendation> recommendations = findWeightRange(weight);
        KiteSizeRecommendation finalRecommendation = findWindRange(windSpeed, recommendations);
        return finalRecommendation.getKiteSize();
    }

    /**
     * @param weight
     * @return a list of kite size recommendations for my weight range
     */
    protected List<KiteSizeRecommendation> findWeightRange(double weight) {
        List<KiteSizeRecommendation> allRecommendations = dao.getAllRecommendations();
        List<KiteSizeRecommendation> windRecommendations = new ArrayList<KiteSizeRecommendation>();
        for (KiteSizeRecommendation recommendation : allRecommendations) {
            if (recommendation.weightMatches(weight)) {
                windRecommendations.add(recommendation);
            }
        }
        return windRecommendations;
    }

    /**
     * @param windSpeed
     * @param recommendations
     * @return a single recommendation based on wind range
     */
    protected KiteSizeRecommendation findWindRange(int windSpeed, List<KiteSizeRecommendation> recommendations) {
        for (KiteSizeRecommendation recommendation : recommendations) {
            if (recommendation.windMatches(windSpeed)) {
                return recommendation;
            }
        }
        if (windSpeed < dao.getMinimumWindSpeed()) {
            throw new BelowMinimumWindSpeedException();
        }

        /*
         * this should be unreachable code based on the data in the kitesizechart table
         */
        throw new IllegalArgumentException("Cannot calculate kite size.");
    }

}
