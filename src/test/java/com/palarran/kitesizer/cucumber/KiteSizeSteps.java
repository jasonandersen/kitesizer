package com.palarran.kitesizer.cucumber;

import static org.junit.Assert.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.palarran.kitesizer.ui.KiteSizeRequest;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Cucumber step definitions for BDD tests.
 */
public class KiteSizeSteps {

    private static Logger log = LoggerFactory.getLogger(KiteSizeSteps.class);

    private String weight;

    private String windSpeed;

    private KiteSizeRequest request;

    @Before
    public void reset() {
        request = null;
    }

    @Given("^I weigh \"([^\"]*)\" pounds$")
    public void iWeighPounds(String weightArg) {
        log.info("I weigh {} pounds.", weightArg);
        this.weight = weightArg;
    }

    @Given("^I normally kite in \"([^\"]*)\" knots of wind$")
    public void iNormallyKiteInKnotsOfWind(String windSpeedArg) {
        log.info("I normally kite in {} knots of wind.", windSpeedArg);
        this.windSpeed = windSpeedArg;
    }

    @When("^I calculate kite size$")
    public void iCalculateKiteSize() throws Throwable {
        log.info("I calculate kite size.");
        request = new KiteSizeRequest(weight, windSpeed);
    }

    @Then("^my kite size should be (\\d+)$")
    public void myKiteSizeShouldBe(Integer expectedKiteSize) {
        log.info("My kite size should be {}.", expectedKiteSize);
        assertEquals(expectedKiteSize, request.getKiteSize());
    }

    @Then("^I see the message \"([^\"]*)\"$")
    public void iSeeTheMessage(String message) {
        assertEquals(message, request.getResponseText());
    }

}
