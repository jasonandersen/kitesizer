package com.palarran.kitesizer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service that calculates kite sizes.
 */
public class KiteSizeService {

    private static Logger log = LoggerFactory.getLogger(KiteSizeService.class);

    private KiteSizeDAO dao = new KiteSizeDAO();

    private List<KiteSizeRecommendation> allRecommendations;

    /**
     * @param weight
     * @param windSpeed
     * @return a calculated kite size based on weight and wind speed
     */
    public int calculateKiteSize(double weight, double windSpeed) {
        log.debug("Calculating kite size for weight of {} and wind speed of {}.", weight, windSpeed);
        validateArguments(weight, windSpeed);
        for (KiteSizeRecommendation recommendation : getAllRecommendations()) {
            if (recommendation.weightMatches(weight) && recommendation.windMatches(windSpeed)) {
                return recommendation.getKiteSize();
            }
        }
        /*
         * this should be unreachable code based on the data in the kitesizechart table and the
         * guard code put in place in validateArguments() method
         */
        throw new IllegalArgumentException("Cannot calculate kite size.");
    }

    /**
     * @return a lazy loaded list of all kite size recommendations
     */
    private List<KiteSizeRecommendation> getAllRecommendations() {
        if (allRecommendations == null) {
            allRecommendations = dao.getAllRecommendations();
        }
        return allRecommendations;
    }

    /**
     * Throws an exception if either argument is outside of the thresholds.
     * @param weight
     * @param windSpeed
     */
    private void validateArguments(double weight, double windSpeed) {
        if (weight < dao.getMinimumWeight()) {
            throw new BelowMinimumWeightException();
        }
        if (weight >= dao.getMaximumWeight()) {
            throw new AboveMaximumWeightException();
        }
        if (windSpeed < dao.getMinimumWindSpeed()) {
            throw new BelowMinimumWindSpeedException();
        }
        if (windSpeed >= dao.getMaximumWindSpeed()) {
            throw new AboveMaximumWindSpeedException();
        }
    }

}
