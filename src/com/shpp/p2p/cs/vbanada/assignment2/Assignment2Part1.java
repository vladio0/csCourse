package com.shpp.p2p.cs.vbanada.assignment2;

import com.shpp.cs.a.console.TextProgram;

/* Program to solve the equation*/

public class Assignment2Part1 extends TextProgram {
    /**
     * Enter a, b and c
     * <p>
     * Checking case when a = 0, then solve the linear equation
     * <p>
     * If a != 0, then solve the discriminant
     */
    @Override
    public void run() {
        double a = readDouble("Please enter a: ");
        double b = readDouble("Please enter b: ");
        double c = readDouble("Please enter c: ");

        if (a == 0) {
            solvingLinear(b, c);
        }
        else{
            solvingDiscriminant(a, b, c);
        }
    }

    /*
        Solving quadratic equation with discriminant
     */
    private void solvingDiscriminant(double a, double b, double c) {
        double d = b * b - 4 * a * c;
        println("Discriminant equals: " + d);
        if (d > 0) {
            println(
                    "There are two roots: "
                            + (-b + Math.sqrt(d)) / (2 * a) +
                            " and " + (-b - Math.sqrt(d)) / (2 * a)
            );
        } else if (d == 0) {
            println("There is one root: " + -b / 2 * a);
        } else {
            println("There are no real roots");
        }
    }

    /*
        Solving linear equation if a = 0

        Equation has form: bx + c = 0;
        x = -c/b

        if b = 0, no more roots, but if c = 0 - equation has many solutions

        if c = 0,
        equation has form: bx = 0;
        x = 0
     */
    private void solvingLinear(double b, double c) {
        println("a = 0\n" +
                "There is no more quadratic equation.");
        if (b == 0) {
            if (c == 0) {
                println("The equation has many solutions (0 = 0)");
            } else {
                println("There are no real roots");
            }
        } else if (c == 0) {
            println("There is one root: 0");
        } else {
            println("There is one root: " + -c / b);
        }
    }
}
