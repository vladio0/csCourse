package com.shpp.p2p.cs.vbanada.assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;

import java.awt.*;

/*
    Program to draw caterpillar
 */

public class Assignment2Part6 extends WindowProgram {
    //Diameter of each part
    private static final int DIAMETER = 100;
    //Parts amount to easy change this value
    private static final int PARTS_AMOUNT = 7;

    private static final int X_COORDITANE_TO_MOVE = 70;
    private static final int Y_COORDITANE_TO_MOVE = 50;
    /*
        Drawing each part of caterpillar

        Changing coordinates of pair parts
        and for odd parts with cycles
     */
    @Override
    public void run() {
        drawCaterpillar();
    }

    private void drawCaterpillar() {
        for (int i = 0; i < PARTS_AMOUNT; i++) {
            if (i % 2 == 0) {
                GOval pair = new GOval(
                        i * X_COORDITANE_TO_MOVE,
                        Y_COORDITANE_TO_MOVE,
                        DIAMETER,
                        DIAMETER);
                fillOvalAndAdd(pair);
            }
            else{
                GOval odd = new GOval(
                        i * X_COORDITANE_TO_MOVE,
                        0,
                        DIAMETER,
                        DIAMETER);
                fillOvalAndAdd(odd);
            }
        }
    }

    /*
        Paint over parts of caterpillar
     */
    private void fillOvalAndAdd(GOval oval) {
        oval.setFilled(true);
        oval.setFillColor(Color.GREEN);
        oval.setColor(Color.RED);
        add(oval);
    }
}
