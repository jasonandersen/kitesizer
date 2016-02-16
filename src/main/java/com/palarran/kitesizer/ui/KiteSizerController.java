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

    private String weightPreviousValue;

    @FXML
    private TextField windSpeed;

    private String windSpeedPreviousValue;

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

    /**
     * Calculates kite size based on values in the text fields.
     */
    private void calculateKiteSize() {
        String weightValue = weight.getText();
        String windSpeedValue = windSpeed.getText();
        if (textFieldsHaveChanged()) {
            //only request a calculation when the value of one of the text fields has changed
            log.debug("User requested kite size calculation for {} pounds and {} knots of wind speed", weightValue,
                    windSpeedValue);
            KiteSizeRequest request = new KiteSizeRequest(weightValue, windSpeedValue);
            kiteSizeResponse.setText(request.getResponseText());
            updateTextFieldsPreviousValues();
        }
    }

    /**
     * Update the previous values to track changes in the text fields.
     */
    private void updateTextFieldsPreviousValues() {
        weightPreviousValue = weight.getText();
        windSpeedPreviousValue = windSpeed.getText();
    }

    /**
     * @return true if the text fields have changed since the last calculation
     */
    private boolean textFieldsHaveChanged() {
        String weightValue = weight.getText();
        String windSpeedValue = windSpeed.getText();
        boolean weightChanged = (!weightValue.equals(weightPreviousValue));
        boolean windSpeedChanged = (!windSpeedValue.equals(windSpeedPreviousValue));
        return weightChanged || windSpeedChanged;
    }

}
