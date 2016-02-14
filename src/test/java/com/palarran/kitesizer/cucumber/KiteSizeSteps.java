package com.palarran.kitesizer.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.palarran.kitesizer.BelowMinimumWindSpeedException;
import com.palarran.kitesizer.KiteSizeService;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Cucumber step definitions for BDD tests.
 */
public class KiteSizeSteps {

    private static Logger log = LoggerFactory.getLogger(KiteSizeSteps.class);

    private double weight;

    private int windSpeed;

    private Integer returnedKiteSize;

    private KiteSizeService kiteSizeService = new KiteSizeService();

    private Exception exception;

    @Before
    public void reset() {
        exception = null;
        returnedKiteSize = null;
    }

    @Given("^I weigh (-?\\d+\\.?\\d+?) pounds$")
    public void iWeighPounds(double weightArg) {
        log.info("I weigh {} pounds.", weightArg);
        this.weight = weightArg;
    }

    @Given("^I normally kite in (\\d+) knots of wind$")
    public void iNormallyKiteInKnotsOfWind(int windSpeedArg) throws Throwable {
        log.info("I normally kite in {} knots of wind.", windSpeedArg);
        this.windSpeed = windSpeedArg;
    }

    @When("^I calculate kite size$")
    public void iCalculateKiteSize() throws Throwable {
        log.info("I calculate kite size.");
        try {
            returnedKiteSize = kiteSizeService.calculateKiteSize(weight, windSpeed);
        } catch (Exception e) {
            exception = e;
        }
    }

    @Then("^my kite size should be (\\d+)$")
    public void myKiteSizeShouldBe(int expectedKiteSize) throws Throwable {
        log.info("My kite size should be {}.", expectedKiteSize);
        assertNull(exception);
        assertEquals(expectedKiteSize, (int) returnedKiteSize);
    }

    @Then("^the wind is too low to calculate a kite size$")
    public void theWindIsTooLowToCalculateAKiteSize() throws Throwable {
        log.info("The wind is too low to calculate a kite size.");
        assertNotNull(exception);
        assertEquals(BelowMinimumWindSpeedException.class, exception.getClass());
    }
}
