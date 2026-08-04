package com.shpp.p2p.cs.vbanada.assignment1;
/*
    Program in which Karel finds a middle on the South line

    I decided to make a counter, which will be increase if Karel put beeper
    and decrease if Karel picks a beeper form West and from East one by one. In final result - counter will be
    empty but one beeper left at the middle.
 */
public class Assignment1Part2 extends SuperKarel {
   /*
        Precondition: Karel stays in Southwestern corner and looks to the East
        Result: One beeper left at the middle of South line
    */

    @Override
    public void run() throws Exception {
        //put first beeper and puts first counter
        putFirstBeeperAndPutInCounter();
        //filling a row, and count beepers except last cell in South line
        //so counter will be smaller by 1
        fillAllRowWithBeepersAndCount();

        //Karel picks first beeper from line
        pickBeeperFromStart();
        //and picks first from counter
        pickFromCounter();
        //then checks counter
        pickOneFromLineAndOneFromCounter();
    }

    /*
        Precondition: Karel stays in start position
        Result: Karel puts first beeper on first cell in line and puts beeper
        in counter, moves from counter to start position
     */
    private void putFirstBeeperAndPutInCounter() throws Exception {
        putBeeper();
        turnLeft();
        move();
        putBeeper();
        moveToStartFromCounter();
    }

    /*
        Precondition: Karel stays in counter
        Result: Karel comes back from counter to start position
     */
    private void moveToStartFromCounter() throws Exception {
        turnAround();
        move();
        turnLeft();
    }

    /*
        Precondition: Karel stays in start position and
            already filled first cell in South line
        Result: Karel steps, puts one more beeper. If beeper already
        present - moves to next cell, then Karel puts beeper in cell in South line
     */
    private void moveToPutAnotherBeeper() throws Exception {
        if (frontIsClear()) {
            move();
            while (beepersPresent()) {
                move();
            }
            putBeeper();
        }
    }

    /*
        Precondition: Karel put one beeper in cell in South line
        Result: Karel comes back to counter and puts one more to counter
     */

    private void addToCounter() throws Exception {
        turnAround();
        while (frontIsClear()) {
            move();
        }
        turnRight();
        move();
        putBeeper();
    }

    /*
        Precondition: Karel in start position
        Result: Karel puts beeper, comes back to counter, moves back to start position
     */
    private void fillAllRowWithBeepersAndCount() throws Exception {
        while (frontIsClear()) {
            moveToPutAnotherBeeper();
            if (frontIsClear()) {
                addToCounter();
                moveToStartFromCounter();
            }
        }
        moveToStartFromEndOfRow();
    }


    /*
        Precondition: Karel stays in the end of line
        Result: Karel turns around and comes back to start position
     */
    private void moveToStartFromEndOfRow() throws Exception {
        turnAround();
        while (frontIsClear()) {
            move();
        }
        turnAround();
    }

    /*
        Precondition: Karel stays in start position
        Result: Karel picks beeper from the start(west side)
     */
    private void pickBeeperFromStart() throws Exception {
        while (noBeepersPresent()) {
            move();
        }
        if (beepersPresent()) {
            pickBeeper();
        }
    }

    /*
        Precondition: Karel stays in start position
        Result: Karel goes to counter and picks a beeper if it exists
     */

    private void pickFromCounter() throws Exception {
        turnLeft();
        move();
        if (beepersPresent()) {
            pickBeeper();
        }
    }

    /*
        Precondition: Karel stays in start position
        Result: Karel goes in the end of line, checking if there is beepers and pick it.
            If not - moves to first beeper(from east side) and picks it
     */
    private void pickBeeperFromEnd() throws Exception {
        while (frontIsClear()) {
            move();
        }
        if (beepersPresent()) {
            pickBeeper();
        } else {
            turnAround();
            while (noBeepersPresent()) {
                move();
            }
            pickBeeper();
            turnAround();
        }
    }

    /*
        Precondition: Karel stays in counter position
        Result: Karel checks counter - if counter 0 - finish
        Karel picks beepers one from west and one from east one by one
     */
    private void pickOneFromLineAndOneFromCounter() throws Exception {
        while (beepersPresent()) {
            pickOneFromEastAndCounter();
            pickOneFromWestAndCounter();
            pickOneFromEastAndCounter();
        }
    }

    /*
        Precondition: Karel stays on counter
        Result: Karel picks one beeper from East side and one from counter
     */
    private void pickOneFromEastAndCounter() throws Exception{
        moveToStartFromCounter();
        pickBeeperFromEnd();
        moveToStartFromEndOfRow();
        pickFromCounter();
    }

    /*
        Precondition: Karel stays on counter
        Result: Karel picks one beeper from West side and one from counter
     */
    private void pickOneFromWestAndCounter() throws Exception{
        moveToStartFromCounter();
        pickBeeperFromStart();
        moveToStartFromEndOfRow();
        pickFromCounter();
    }
}
