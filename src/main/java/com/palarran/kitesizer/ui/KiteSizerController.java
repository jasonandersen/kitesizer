package com.palarran.kitesizer.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Controller for the KiteSizer JavaFX UI. This class handles all communication to and
 * from the JavaFX controls.
 */
public class KiteSizerController {

    private static Logger log = LoggerFactory.getLogger(KiteSizerController.class);

    @FXML
    private TextField weight;

    @FXML
    private TextField windSpeed;

    @FXML
    private Label kiteSizeResponse;

    @FXML
    private void handleCalculateButtonClick() {
        calculateKiteSize();
    }

    @FXML
    private void handleOnKeyTyped() {
        calculateKiteSize();
    }

    private void calculateKiteSize() {
        String weightValue = weight.getText();
        String windSpeedValue = windSpeed.getText();
        log.debug("User requested kite size calculation for {} pounds and {} knots of wind speed", weightValue, windSpeedValue);
        KiteSizeRequest request = new KiteSizeRequest(weightValue, windSpeedValue);
        kiteSizeResponse.setText(request.getResponseText());
    }

}
