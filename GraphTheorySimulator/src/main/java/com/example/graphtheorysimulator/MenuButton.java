package com.example.graphtheorysimulator;

import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class MenuButton extends Button {
    private static final int BUTTON_WIDTH = 100;
    private static final int BUTTON_HEIGHT = 50;

    /**
     * Creates a default menu button.
     * @param text The text displayed on button.
     */
    public MenuButton(String text) {
        setText(text);
        //setPrefWidth();
        //setPrefHeight(BUTTON_HEIGHT);
        setPadding(new Insets(20));
    }

}
