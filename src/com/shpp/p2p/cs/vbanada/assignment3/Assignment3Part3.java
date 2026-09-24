package com.shpp.p2p.cs.vbanada.assignment3;

import com.shpp.cs.a.console.TextProgram;

/*
    Program "Raising to a power"
 */
public class Assignment3Part3 extends TextProgram {
    //Creating constants for Stings
    private static final String ENTER_BASE = "Enter base to raise: ";
    private static final String ENTER_EXPONENT = "Enter exponent: ";
    private static final String GREATER_ZERO = "Base 0 can`t be raised by exponent that smaller than 0";
    private static final String RESULT = "Result is: %.2f";
    /*
        Enter base and exponent
        If you enter base - 0 and exponent smaller than 0 - it`s error(can`t divide on 0)
        Else - running a program
     */
    @Override
    public void run() {
        double base = readDouble(String.format(ENTER_BASE));
        int exponent = readInt(String.format(ENTER_EXPONENT));
        if (base == 0 && exponent < 0) {
            println(String.format(GREATER_ZERO));
        } else {
            double result = raiseToPower(base, exponent);
            println(String.format(RESULT, result));

        }
    }
    /*
        Finding result of raising to a power
     */
    private double raiseToPower(double base, int exponent) {
        double result = 1;
        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                result *= base;
            }
        } else if (exponent < 0) {
            for (int i = exponent; i < 0; i++) {
                result *= (1 / base);
            }
        }
        return result;
    }
}

