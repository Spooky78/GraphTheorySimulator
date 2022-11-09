package com.example.graphtheorysimulator;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 * Responsible for the nodes of the graph.
 * @author Spooky78
 */
public class Node extends Circle {
    private static final int DEFAULT_RADIUS = 20;
    private static final Color DEFAULT_COLOUR = Color.rgb(87, 177, 150);
    private static int defaultNodeIndex = 0;
    private final Text nodeText;
    private final StackPane nodeStack;

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
