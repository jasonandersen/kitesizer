package com.palarran.kitesizer.ui;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Boots up the JavaFX application UI.
 */
public class KiteSizerApp extends Application {

    private static Logger log = LoggerFactory.getLogger(KiteSizerApp.class);

    private Stage primaryStage;

    private BorderPane rootLayout;

    /**
     * Boot strap.
     * @param args
     */
    public static void main(String[] args) {
        log.info("Booting up the JavaFX UI.");
        launch(args);
    }

    /**
     * @see javafx.application.Application#start(javafx.stage.Stage)
     */
    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        this.primaryStage.setTitle("Kite Sizer");
        initLayout();
    }

    /**
     * Initialize the UI layout
     * @throws IOException 
     */
    private void initLayout() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        /*
         * JavaFX uses FXML files to create UI layouts. This file is located at:
         *      src/main/resources/view/KiteSizer.fxml
         *  
         * If you want to edit FXML files, down SceneBuilder (it's free). It's a 
         * WYSIWYG editor for JavaFX UIs.
         */
        loader.setLocation(KiteSizerApp.class.getResource("/view/KiteSizer.fxml"));
        rootLayout = (BorderPane) loader.load();

        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
