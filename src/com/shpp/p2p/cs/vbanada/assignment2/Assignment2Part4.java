package com.shpp.p2p.cs.vbanada.assignment2;

import acm.graphics.GLabel;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
    Program to draw a three colors flag
 */

public class Assignment2Part4 extends WindowProgram {

    // The default W and H of the window.
    public static final int APPLICATION_WIDTH = 300;
    public static final int APPLICATION_HEIGHT = 300;

    //width and height of each flag color
    static final double RECT_WIDTH = 200;
    static final double RECT_HEIGHT = 50;

    //constants to custom colors
    private static final Color FOREST_GREEN = new Color(0, 158, 96);
    private static final Color GOLD_YELLOW = new Color(252, 209, 22);
    private static final Color ROYAL_BLUE = new Color(58, 117, 196);


    //    private static final int
    /*
        Making x and y coordinates of first part of flag
        Than drawing three Rectangles
        Adding a GLabel in the right lower corner
     */
    @Override
    public void run() {
        drawFlag();
        writeLabel();
    }

    /*
        Drawing flag with X and Y coordinates to locate each part of flag in correct position
     */
    private void drawFlag() {
        double x = (double) getWidth() / 2 - RECT_WIDTH / 2;
        double y = (double) getHeight() / 2 - (RECT_HEIGHT * 3 / 2);

        add(createRectangle(FOREST_GREEN, x, y));
        add(createRectangle(GOLD_YELLOW, x, y + (RECT_HEIGHT / 2) * 2));
        add(createRectangle(ROYAL_BLUE, x, y + (RECT_HEIGHT / 2) * 2 + (RECT_HEIGHT / 2) * 2));
    }

    /*
        Writing label in the right lower corner
        Finding coordinates with X and Y
        setting location of label
     */
    private void writeLabel() {
        String flagName = "Flag of Gabon Republic";
        GLabel countryName = new GLabel(flagName);

        double x = getWidth() - countryName.getWidth();
        double y = getHeight() - countryName.getHeight();

        countryName.setLocation(x, y);
        add(countryName);
    }

    /*
        Creating a rectangle
     */
    private GRect createRectangle(Color color, double x, double y) {
        GRect rect = new GRect(
                x,
                y,
                Assignment2Part4.RECT_WIDTH,
                Assignment2Part4.RECT_HEIGHT
        );
        fillRectangle(rect, color);
        return rect;
    }

    /*
        Painting over every part of the flag.
     */
    private void fillRectangle(GRect rect, Color color) {
        rect.setColor(color);
        rect.setFilled(true);
        add(rect);
    }
}
