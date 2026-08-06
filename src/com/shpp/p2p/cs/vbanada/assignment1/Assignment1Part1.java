package com.shpp.p2p.cs.vbanada.assignment1;

/*
    Program in which Karel makes a stones row to column
 */
public class Assignment1Part1 extends SuperKarel {
    /*
        Precondition: Karel stays in Southwestern corner and looks to the East
        Result: Karel put the line from stones to each column
     */
    @Override
    public void run() throws Exception {
        //walk to column
        putBeeperOnWayToColumn();
        checkNextColumnAndPutStones();
    }

    /* Precondition: Karel staying in start position
       Result: Karel putting stone(beeper) until the column.
            Karel checks every cell if stone already exists.
            If cell is empty - Karel put stone in cell.

            to avoid problem with forgetting the last step
            checking process one more time after cycle
     */
    private void putBeeperOnWayToColumn() throws Exception {
        turnLeft(); // turn to column
        while (frontIsClear()) {
            checkIsBeeperInCell();
            move();
        }
        checkIsBeeperInCell();
    }


    /*
        Precondition: Karel put stones in a line to column
        Result: Karel checks right on a way back from every column, because he needs to know
         if there are any more columns.
        Karel comes back to first row, makes 4 steps to next column
            (we already know that column on 1,5,9 ect.) and put stones again
     */
    private void checkNextColumnAndPutStones() throws Exception {
        while (rightIsClear()) {
            moveBack();
            stepsToNextColumn();
            putBeeperOnWayToColumn();
        }
    }

    /*
        Precondition: Karel filled a line and needs to come back
        Result: Karel came back to first row
     */
    private void moveBack() throws Exception {
        turnAround();
        moveUntilWall();
        turnLeft();
    }

    /*
        Precondition: Karel needs to move to next column
        Result: Karel moves 4 steps to next column
     */
    private void stepsToNextColumn() throws Exception {
        for (int i = 0; i < 4; i++) {
            move();
        }
    }

    // checking if beeper is in the last cell
    // if not - put beeper in cell
    private void checkIsBeeperInCell() throws Exception {
        if (noBeepersPresent()) {
            putBeeper();
        }
    }


}
