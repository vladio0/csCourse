package com.shpp.p2p.cs.vbanada.assignment2;

import acm.graphics.GRect;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
    Program to draw a matrix
 */

public class Assignment2Part5 extends WindowProgram {

    /* The number of rows and columns in the grid, respectively. */
    private static final int NUM_ROWS = 5;
    private static final int NUM_COLS = 6;

    /* The width and height of each box. */
    private static final double BOX_SIZE = 40;

    /* The horizontal and vertical spacing between the boxes. */
    private static final double BOX_SPACING = 10;

    /*
        Making totalWidth and totalHeight to find total size of matrix.
        Finding startX and startY to draw matrix in the middle of program.
        Drawing a matrix.
     */
    @Override
    public void run() {

        double totalWidth = (NUM_COLS * BOX_SIZE) + (NUM_COLS - 1) * BOX_SPACING;
        double totalHeight = (NUM_ROWS * BOX_SIZE) + (NUM_ROWS - 1) * BOX_SPACING;

        double startX = (double) getWidth() / 2 - totalWidth / 2;
        double startY = (double) getHeight() / 2 - totalHeight / 2;

        drawMatrix(startX, startY);
    }

    /**
     * Drawing first matrix that is located in the left upper corner of program, but not adding it to program
     * <p>
     * Finding currentX and currentY of each matrix element
     * <p>
     * Drawing current element of matrix at the calculated position
     * <p>
     * And adding element to program
     */
    private void drawMatrix(double startX, double startY) {
        for (int i = 0; i < NUM_COLS; i++) {
            for (int j = 0; j < NUM_ROWS; j++) {
                GRect rect = new GRect(
                        i * (BOX_SIZE + BOX_SPACING),
                        j * (BOX_SIZE + BOX_SPACING),
                        BOX_SIZE,
                        BOX_SIZE
                );

                double currentX = startX + i * (BOX_SIZE + BOX_SPACING);
                double currentY = startY + j * (BOX_SIZE + BOX_SPACING);

                GRect centeredRect = new GRect(
                        currentX,
                        currentY,
                        BOX_SIZE,
                        BOX_SIZE
                );
                centeredRect.setFilled(true);
                add(centeredRect);
            }
        }
    }
}
