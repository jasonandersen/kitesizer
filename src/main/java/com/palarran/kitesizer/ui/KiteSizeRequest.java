package com.palarran.kitesizer.ui;

import com.palarran.kitesizer.AboveMaximumWindSpeedException;
import com.palarran.kitesizer.BelowMinimumWindSpeedException;
import com.palarran.kitesizer.KiteSizeService;

/**
 * This class bundles a request from the UI and formats the response for display.
 * This is broken out into it's own class (rather than keeping this logic in the
 * {@link KiteSizerController} class) so we can break it out and test it without the
 * hassle of dealing with the JavaFX objects.
 */
public class KiteSizeRequest {

    private final String weightValue;

    private final String windSpeedValue;

    private final KiteSizeService service;

    private final String response;

    private Integer kiteSize;

    /**
     * @param weightValue
     * @param windSpeedValue
     */
    public KiteSizeRequest(String weightValue, String windSpeedValue) {
        this.weightValue = weightValue;
        this.windSpeedValue = windSpeedValue;
        service = new KiteSizeService();
        response = initResponse();
    }

    /**
     * @return the response to this request
     */
    private String initResponse() {
        int weight = Integer.parseInt(weightValue);
        int windSpeed = Integer.parseInt(windSpeedValue);
        String out;
        try {
            kiteSize = service.calculateKiteSize(weight, windSpeed);
            out = String.format("Your kite size should be %d meters sq.", kiteSize);
        } catch (BelowMinimumWindSpeedException e) {
            out = "There is not enough wind to kite in, brah.";
        } catch (AboveMaximumWindSpeedException e) {
            out = "Too much wind - stay on the beach.";
        }
        return out;
    }

    /**
     * @return the response to this kite size request
     */
    public String getResponseText() {
        return response;
    }

    /**
     * @return a calculated kite size - will return null if kite size could not be calculated
     */
    public Integer getKiteSize() {
        return kiteSize;
    }

}
