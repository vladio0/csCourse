package com.shpp.p2p.cs.vbanada.assignment3;

import com.shpp.cs.a.console.TextProgram;

/*
    Program "Numbers-hailstones"
 */

public class Assignment3Part2 extends TextProgram {
    //creating constants for Strings
    private static final String ENTER_NUMBER = "Enter a number: ";
    private static final String GREATER_ZERO = "Number must be greater than 0";
    private static final String RESULT = "Result is 1 - the end";
    private static final String EVEN = "%d is even so I take half: ";
    private static final String ODD = "%d is odd so I make 3n + 1: ";
    /*
        1.Entering number
        2.Checking is number is greater than 0
        3.Launching "Numbers-hailstones"
     */
    @Override
    public void run() {
        int n = readInt(String.format(ENTER_NUMBER));
        if (n < 0) {
            println(String.format(GREATER_ZERO));
        }
        else {
            hailLaunch(n);
            print(String.format(RESULT));
        }
    }

    /*
        While number not equals 1 checking even or odd
        if even - divide by 2
        if odd - (3 * n) + 1
        making that until number don`t equals 1
     */
    private void hailLaunch(int n) {
        do {
            if (n % 2 == 0) {
                print(String.format(EVEN, n));
                n /= 2;
                println(n);
            } else {
                print(String.format(ODD, n));
                n = (3 * n) + 1;
                println(n);
            }
        } while (n != 1);
    }
}
