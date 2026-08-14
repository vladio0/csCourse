package com.shpp.p2p.cs.vbanada.assignment2;

import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
    Program to draw illusory contours
 */

public class Assignment2Part2 extends WindowProgram {
    //Diameter of every circles
    public static final int DIAMETER = 200;

    public static final int CIRCLES_COUNT_IN_COL = 2;
    public static final int CIRCLES_COUNT_IN_ROW = 2;

    public static final int APPLICATION_WIDTH = 600;
    public static final int APPLICATION_HEIGHT = 600;

    /*
        Drawing four circles and then rectangle
     */
    @Override
    public void run() {
        drawFourCircles();
        drawRectangle();
    }

    /*
        Drawing rectangle and placing it each corner in the middle of each oval center
     */
    private void drawRectangle() {
        GRect rect = new GRect(
                (double) DIAMETER / 2,
                (double) DIAMETER / 2,
                getWidth() - DIAMETER,
                getHeight() - DIAMETER
        );
        rect.setFilled(true);
        fillAndAddFigure(rect, Color.WHITE);
    }

    /*
        Drawing four circles like matrix 2x2
        Locating each element in corner of window application
     */
    private void drawFourCircles() {
        for (int i = 0; i < CIRCLES_COUNT_IN_COL; i++) {
            for (int j = 0; j < CIRCLES_COUNT_IN_ROW; j++) {
                GOval circles = new GOval(
                        i * (getWidth() - DIAMETER),
                        j * (getHeight() - DIAMETER),
                        DIAMETER,
                        DIAMETER
                );
                circles.setFilled(true);
                fillAndAddFigure(circles, Color.BLACK);
            }
        }
    }

    /*
        Filling figure and add it to program
     */
    private void fillAndAddFigure(GObject obj, Color color) {
        obj.setColor(color);
        add(obj);
    }
}
