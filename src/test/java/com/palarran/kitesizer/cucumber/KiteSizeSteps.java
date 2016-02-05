package com.palarran.kitesizer.cucumber;

import static org.junit.Assert.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.palarran.kitesizer.KiteSizeService;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * Cucumber step definitions for BDD tests.
 */
public class KiteSizeSteps {

    private static Logger log = LoggerFactory.getLogger(KiteSizeSteps.class);

    private double weight;

    private int windSpeed;

    private int returnedKiteSize;

    private KiteSizeService kiteSizeService = new KiteSizeService();

    @Given("^I weigh (-?\\d+\\.?\\d+?) pounds$")
    public void iWeighPounds(double weight) {
        this.weight = weight;
    }

    @Given("^I normally kite in (\\d+) knots of wind$")
    public void iNormallyKiteInKnotsOfWind(int windSpeed) throws Throwable {
        this.windSpeed = windSpeed;
    }

    @Then("^my kite size should be (\\d+)$")
    public void myKiteSizeShouldBe(int expectedKiteSize) throws Throwable {
        returnedKiteSize = kiteSizeService.calculateKiteSize(weight, windSpeed);
        assertEquals(expectedKiteSize, returnedKiteSize);
    }

    @Then("^the wind is too low to calculate a kite size$")
    public void theWindIsTooLowToCalculateAKiteSize() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
