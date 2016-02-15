package com.palarran.kitesizer.ui;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * User interface based on JavaFX.
 */
public class KiteSizerApp extends Application {

    private Stage primaryStage;

    private BorderPane rootLayout;

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
        loader.setLocation(KiteSizerApp.class.getResource("/view/KiteSizer.fxml"));
        rootLayout = (BorderPane) loader.load();

        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Boot strap.
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}
