package com.example.graphtheorysimulator;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Responsible for the main menu window.
 * @author Spooky78
 */
public class ViewManager {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private final AnchorPane mainPane;
    private final Scene mainScene;
    private final Stage mainStage;

    /**
     * Creates a main menu window.
     */
    public ViewManager() {
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createBackground();
    }


    /**
     * Sets the background to an off-white.
     */
    private void createBackground() {
        Background background = new Background(new BackgroundFill(
            Color.rgb(232, 232, 231) , CornerRadii.EMPTY, Insets.EMPTY));
        mainPane.setBackground(background);
    }

    /**
     * Gets main stage.
     * @return The main stage.
     */
    public Stage getMainStage() {
        return mainStage;
    }
}
