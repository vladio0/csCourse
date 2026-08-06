package com.shpp.p2p.cs.vbanada.assignment1;
/*
    Program in which Karel puts beepers in checkerboard order
 */
public class Assignment1Part3 extends SuperKarel {
    /*
        Precondition: Karel stays in Southwestern corner and looks to the East
        Result: Karel put beepers in checkerboard order all over the world
     */
    @Override
    public void run() throws Exception {
        //Karel checks that he faces the East
        while (facingEast()) {
            putBeeper();
            fillOddRowAndComeBack();
            if (rightIsClear()) {
                fillPairRowAndComeBack();
            }
        }
    }

    /*
        Precondition: no precondition, Karel wants to fill the odd row with beepers in chess order
        Result: Karel fills odd row through one
     */
    private void fillOddRowAndComeBack() throws Exception {

        while (frontIsClear()) {
            move();
            if (frontIsClear()) {
                move();
                putBeeper();
            }
        }
        comeBackAndStepToNextRow();
    }
    /*
        Precondition: Karel already filled odd row(first row), moved to next(pair row if it exists)
        Result: Karel starts fill pair row thought one, to complete chess order
     */
    private void fillPairRowAndComeBack() throws Exception {
        while (frontIsClear()) {
            move();
            putBeeper();
            if (frontIsClear()) {
                move();
            }
        }
        comeBackAndStepToNextRow();
    }

    private void comeBackAndStepToNextRow() throws Exception {
        turnAround();
        while (frontIsClear()) {
            move();
        }
        if (rightIsClear()) {
            turnRight();
            move();
            turnRight();
        }
    }
}




