package com.palarran.kitesizer.cucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;

/**
 * Step definitions for BDD tests.
 */
public class KiteSizeSteps {

    @Given("^I weigh (\\d+) pounds$")
    public void iWeighPounds(int weight) {
        throw new PendingException();
    }

}
