package com.palarran.kitesizer.cucumber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

/**
 * Step definitions for BDD tests.
 */
public class KiteSizeSteps {

    private static Logger log = LoggerFactory.getLogger(KiteSizeSteps.class);

    @Given("^I weigh (-?\\d+\\.?\\d+?) pounds$")
    public void iWeighPounds(double weight) {
        log.debug("Step definition: Given I weigh {} pounds.", weight);
        throw new PendingException();
    }

}
