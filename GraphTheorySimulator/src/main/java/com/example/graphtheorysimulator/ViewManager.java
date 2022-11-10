package com.example.graphtheorysimulator;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
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
    private static final int BUTTON_LEFT_POSITION_X = 25;
    private static final int BUTTON_RIGHT_POSITION_X = 150;
    private static final int BUTTON_POSITION_Y = 25;
    private static final Color BACKGROUND_COLOUR = Color.rgb(232, 232, 231);
    private final AnchorPane mainPane;
    private final Scene mainScene;
    private final Stage mainStage;
    private boolean isDrawingNode = false;
    private boolean isSelectingNode = false;
    private ArrayList<Node> nodes = new ArrayList<>();

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
        createSelectNodeButton();
    }

    /**
     * Creates the draw node button.
     */
    private void createDrawNodeButton() {
        MenuButton drawNodeButton = new MenuButton("Draw Node");
        drawNodeButton.setLayoutX(BUTTON_LEFT_POSITION_X);
        drawNodeButton.setLayoutY(BUTTON_POSITION_Y);
        mainPane.getChildren().add(drawNodeButton);
        drawNodeButton.setOnAction(actionEvent -> {
            isDrawingNode = true;
            isSelectingNode = false;
            createMouseListenersForNode();
        });
    }

    /**
     * Creates a new node on screen.
     * @param x The x coordinate of where to place node.
     * @param y The y coordinate of where to place node.
     */
    private void createNewNode(double x, double y) {
        Node currentNode = new Node(x, y);
        nodes.add(currentNode);
        StackPane nodeStack = currentNode.getNodeStackPane();
        mainPane.getChildren().add(nodeStack);
    }

    /**
     * Draws node where mouse is clicked.
     */
    private void createMouseListenersForNode() {
        mainScene.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getButton() == MouseButton.PRIMARY) {
                double x = mouseEvent.getX();
                double y = mouseEvent.getY();
                if (isDrawingNode) {
                    createNewNode(x, y);
                } else if (isSelectingNode) {
                    selectNode(x, y);
                    //selectBox(x, y);
                }
            }
        });
    }

    /**
     * Creates button to select node.
     */
    private void createSelectNodeButton() {
        MenuButton selectNodeButton = new MenuButton("Select Node");
        selectNodeButton.setLayoutX(BUTTON_RIGHT_POSITION_X);
        selectNodeButton.setLayoutY(BUTTON_POSITION_Y);
        mainPane.getChildren().add(selectNodeButton);
        selectNodeButton.setOnAction(actionEvent -> {
            isSelectingNode = true;
            isDrawingNode = false;
            createMouseListenersForNode();
        });
    }

    /**
     * Select node from ones draw on screen.
     * @param x The x coordinate of mouse.
     * @param y The y coordinate of mouse.
     */
    private void selectNode(double x, double y) {
        Node selectedNode;
        for (Node node : nodes) {
            node.deselectNode();
            double layoutX = node.getNodeStackPane().getLayoutX();
            double layoutY = node.getNodeStackPane().getLayoutY();
            int radius = node.getNodeRadius();
            if (x > layoutX && x < layoutX + (2 * radius) && y > layoutY && y < layoutY
                + (2 * radius)) {
                selectedNode = node;
                selectedNode.drawSelectBox();

            }
        }
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
