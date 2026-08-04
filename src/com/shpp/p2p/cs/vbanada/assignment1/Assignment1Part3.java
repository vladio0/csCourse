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
            //непраний ряд
            fillOddRowAndComeBack();
            /*
                Precondition: Karel came back from odd row
                Result: One more check, is Karel has right clear to step on pair row
             */
            if (rightIsClear()) {
                //парний ряд
                fillPairRowAndComeBack();
            }
        }
    }

    /*
        Precondition: no precondition, Karel wants to fill the odd row with beepers in chess order
        Result: Karel fills odd row through one
     */
    private void fillOddRowAndComeBack() throws Exception {
        putBeeper();
        while (frontIsClear()) {
            move();
            if (frontIsClear()) {
                move();
                putBeeper();
            }
        }

        /*
            Precondition: Karel stands at the edge of the odd line
            Result: Karel comes back to start. If next row exists - moves next
         */
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
        //Karel comes back to start of row, and checks for another row.
        turnAround();
        while (frontIsClear()) {
            move();
        }
        // If next row exists - steps on next(odd) row.
        if (rightIsClear()) {
            turnRight();
            move();
            turnRight();
        }
    }
}




