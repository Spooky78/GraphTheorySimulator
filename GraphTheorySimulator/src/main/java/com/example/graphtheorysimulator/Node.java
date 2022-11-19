package com.example.graphtheorysimulator;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

/**
 * Responsible for the nodes of the graph.
 * @author Spooky78
 */
public class Node extends Circle {
    private static boolean isNodeSelected = false;
    private static final int DEFAULT_RADIUS = 20;
    private static final Color DEFAULT_COLOUR = Color.rgb(87, 177, 150);
    private static int defaultNodeIndex = 0;
    private final Text nodeText;
    private final StackPane nodeStack;
    private Rectangle selectBox;

    /**
     * Creates a default node.
     * @param x The x coordinate of where to place node.
     * @param y The y coordinate of where to place node.
     */
    public Node(double x, double y) {
        this.setRadius(DEFAULT_RADIUS);
        this.setFill(DEFAULT_COLOUR);

        this.nodeText = new Text(Integer.toString(defaultNodeIndex));
        defaultNodeIndex++;

        nodeStack = new StackPane();
        nodeStack.getChildren().addAll(this, nodeText);
        nodeStack.setLayoutX(x - DEFAULT_RADIUS);
        nodeStack.setLayoutY(y - DEFAULT_RADIUS);
    }

    /**
     * Draws a box around node which is selected.
     */
    public void drawSelectBox() {
        selectBox = new Rectangle(this.getLayoutX(), this.getLayoutY(), 2 * DEFAULT_RADIUS,
            2 * DEFAULT_RADIUS);
        selectBox.setFill(Color.TRANSPARENT);
        selectBox.setStroke(Color.BLACK);
        nodeStack.getChildren().add(selectBox);
        isNodeSelected = true;
    }

    /**
     * Removes selection box from scene.
     */
    public void deselectNode() {
        if (isNodeSelected) {
            nodeStack.getChildren().remove(selectBox);
            isNodeSelected = false;
        }
    }

    public void moveNodeWithMouse(Scene scene){
        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //drawSelectBox();
                if(!mouseEvent.isControlDown()){
                    nodeStack.setLayoutX(mouseEvent.getSceneX()-DEFAULT_RADIUS);
                    nodeStack.setLayoutY(mouseEvent.getSceneY()-DEFAULT_RADIUS);
                }
            }
        });
    }

    /**
     * Returns if node is selected.
     * @return True if node is selected.
     */
    public boolean isNodeSelected() {
        return isNodeSelected;
    }

    /**
     * Return the radius of the node.
     * @return The radius of node.
     */
    public int getNodeRadius() {
        return DEFAULT_RADIUS;
    }

    /**
     * Return the text of the node.
     * @return The node of the text.
     */
    public Text getNodeText() {
        return nodeText;
    }

    /**
     * Returns the node stack pane.
     * @return The node stack pane.
     */
    public StackPane getNodeStackPane() {
        return nodeStack;
    }
}
