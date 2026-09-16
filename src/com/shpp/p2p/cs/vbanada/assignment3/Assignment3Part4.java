package com.shpp.p2p.cs.vbanada.assignment3;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;
/*
    Program to build a pyramid
 */
public class Assignment3Part4 extends WindowProgram {
    //height of brick
    private static final double BRICK_HEIGHT = 25;
    //width of brick
    private static final double BRICK_WIDTH = 50;
    //amount of bricks that lie at the base
    private static final int BRICKS_IN_BASE = 9;

    /*
        After creating constants making a cycle;
        Finding a start position to build a first, second, ect. rows;
        Building a row and stepping by one block upper.
     */
    @Override
    public void run() {
        int bricksCounter = BRICKS_IN_BASE;
        int stepInHeight = 1;
        for(int i = 0; i < BRICKS_IN_BASE; i++){
            double x = (double) getWidth() / 2 - (BRICK_WIDTH * bricksCounter / 2);
            double y = getHeight() - (BRICK_HEIGHT) * stepInHeight;
            buildRow(x, y, bricksCounter);
            bricksCounter--;
            stepInHeight += 1;
        }
    }

    /*
        Building a row by coordinates;
        Counting X, to move forward.
     */
    private void buildRow(double x, double y, int bricksCounter) {
        for (int i = 0; i < bricksCounter;i++) {
            GRect row = new GRect(
                    x,
                    y,
                    BRICK_WIDTH,
                    BRICK_HEIGHT
            );
            row.setColor(Color.RED);
            add(row);
            x += (BRICK_WIDTH / 2) * 2;
        }
    }
}
