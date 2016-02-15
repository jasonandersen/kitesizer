package com.palarran.kitesizer.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 * Controller for the KiteSizer JavaFX UI.
 */
public class KiteSizerController {

    private static Logger log = LoggerFactory.getLogger(KiteSizerController.class);

    @FXML
    private TextField weight;

    @FXML
    private TextField windSpeed;

    @FXML
    private void handleCalculateButtonClick() {
        String weightValue = weight.getText();
        String windSpeedValue = windSpeed.getText();
        log.warn("weight: {} windSpeed: {}", weightValue, windSpeedValue);
    }

}
