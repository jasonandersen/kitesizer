package com.palarran.kitesizer.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;

/**
 * Controller for the KiteSizer JavaFX UI. This class handles all communication to and
 * from the JavaFX UI controls.
 */
public class KiteSizerController {

    private static Logger log = LoggerFactory.getLogger(KiteSizerController.class);

    private String windSpeedPreviousValue;

    private String weightPreviousValue;

    @FXML
    private TextField weight;

    @FXML
    private TextField windSpeed;

    @FXML
    private Label kiteSizeResponse;

    @FXML
    private Label kiteSize;

    @FXML
    private Label squareMeters;

    @FXML
    private Circle kiteSizeCircle;

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
            if (request.isValid()) {
                displayValidResponse(request);
            } else {
                displayInvalidResponse(request);
            }
            updateTextFieldsPreviousValues();
        }
    }

    /**
     * Displays an invalid kite size request.
     * @param request
     */
    private void displayInvalidResponse(KiteSizeRequest request) {
        kiteSizeCircle.setVisible(false);
        kiteSize.setText("");
        squareMeters.setVisible(false);
        kiteSizeResponse.setText(request.getResponseText());
    }

    /**
     * Displays a valid kite size response.
     * @param request
     */
    private void displayValidResponse(KiteSizeRequest request) {
        kiteSizeCircle.setVisible(true);
        kiteSize.setText(request.getKiteSize().toString());
        squareMeters.setVisible(true);
        kiteSizeResponse.setText("Your kite size is:");
        kiteSizeResponse.setTextAlignment(TextAlignment.CENTER);
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
