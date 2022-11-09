package com.example.graphtheorysimulator;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Responsible for the main menu window.
 * @author Spooky78
 */
public class ViewManager {
    private static final int WIDTH = 1024;
    private static final int HEIGHT = 760;
    private static final int BUTTON_WIDTH = 150;
    private static final int BUTTON_HEIGHT = 50;
    private static final int BUTTON_POSITION_X = 50;
    private static final int BUTTON_POSITION_Y = 50;
    private static final Color BACKGROUND_COLOUR = Color.rgb(232, 232, 231);
    private final AnchorPane mainPane;
    private final Scene mainScene;
    private final Stage mainStage;
    private boolean isDrawingNode = false;

    /**
     * Creates a main menu window.
     */
    public ViewManager() {
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, WIDTH, HEIGHT);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        createBackground();
        createButtons();
    }

    /**
     * Creates the menu buttons.
     */
    private void createButtons() {
        createDrawNodeButton();
    }

    /**
     * Creates the draw node button.
     */
    private void createDrawNodeButton() {
        Button drawNodeButton = new Button("Draw Node");
        drawNodeButton.setLayoutX(BUTTON_POSITION_X);
        drawNodeButton.setLayoutY(BUTTON_POSITION_Y);
        drawNodeButton.setPrefWidth(BUTTON_WIDTH);
        drawNodeButton.setPrefHeight(BUTTON_HEIGHT);
        mainPane.getChildren().add(drawNodeButton);
        drawNodeButton.setOnAction(actionEvent -> {
            createMouseListeners();
            isDrawingNode = true;
            //createNewNode(nodeX, nodeY);
        });
    }

    /**
     * Creates a new node on screen.
     * @param x The x coordinate of where to place node.
     * @param y The y coordinate of where to place node.
     */
    private void createNewNode(double x, double y) {
        Node currentNode = new Node(x, y);
        StackPane nodeStack = currentNode.getNodeStackPane();
        mainPane.getChildren().add(nodeStack);
    }

    private void createMouseListeners() {
        mainScene.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                double x = mouseEvent.getX();
                double y = mouseEvent.getY();
                if (isDrawingNode) {
                    createNewNode(x, y);
                }
            }
        });
    }

    /**
     * Sets the background to an off-white.
     */
    private void createBackground() {
        Background background = new Background(new BackgroundFill(
            BACKGROUND_COLOUR, CornerRadii.EMPTY, Insets.EMPTY));
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
