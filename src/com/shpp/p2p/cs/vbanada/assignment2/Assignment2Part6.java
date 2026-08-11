package com.shpp.p2p.cs.vbanada.assignment2;

import acm.graphics.GOval;
import com.shpp.cs.a.graphics.WindowProgram;
import java.awt.*;

/*
    Program to draw caterpillar
 */

public class Assignment2Part6 extends WindowProgram {
    //Diameter of each part
    public static final int DIAMETER = 100;
    //Parts amount to easy change this value
    public static final int PARTS_AMOUNT = 8;

    /*
        Drawing each part of caterpillar

        Changing coordinates of pair parts
        and for odd parts with cycles
     */
    @Override
    public void run(){

        for(int i = 0; i < PARTS_AMOUNT; i++){
            if(i % 2 == 0) {
                GOval pair = new GOval(
                        i * 70,
                        50,
                        DIAMETER,
                        DIAMETER);
                fillOvalAndAdd(pair);
            }
            if(i % 2 == 1) {
                GOval odd = new GOval(
                        i * 70,
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
