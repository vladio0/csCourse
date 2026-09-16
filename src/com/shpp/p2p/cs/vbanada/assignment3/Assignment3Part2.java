package com.shpp.p2p.cs.vbanada.assignment3;

import com.shpp.cs.a.console.TextProgram;

/*
    Program "Numbers-hailstones"
 */

public class Assignment3Part2 extends TextProgram {

    /*
        1.Entering number
        2.Checking is number is greater than 0
        3.Launching "Numbers-hailstones"
     */
    @Override
    public void run() {
        int n = readInt("Enter a number: ");
        if (n < 0) {
            println("Number must be greater than 0");
        } else {
            hailLaunch(n);
            print("Result is 1 - the end");
        }
    }

    /*
        While number not equals 1 checking even or odd
        if even - divide by 2
        if odd - (3 * n) + 1
        making that until number don`t equals 1
     */
    private void hailLaunch(int n) {
        while (n != 1) {
            if (n % 2 == 0) {
                print(n + " is even so I take half: ");
                n /= 2;
                println(n);
            } else {
                print(n + " is odd so I make 3n + 1: ");
                n = (3 * n) + 1;
                println(n);
            }
        }
    }
}
