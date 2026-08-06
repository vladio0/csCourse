package com.shpp.p2p.cs.vbanada.assignment1;
/*
    Program in which Karel cleans nuclear reactor
 */
public class Assignment1Part4 extends SuperKarel{
    /*
        Precondition: Karel stays at the start of reactor
        Result: Karel went through reactor and cleaned trash
            to avoid problem with forgetting the last step
                after cycle checking process one more time

     */
    @Override
    public void run() throws Exception {
        while(frontIsClear()){
            checksWallsInReactor();
            move();
        }
        checksWallsInReactor();

    }
/*
    Precondition: Karel stands in corridor, faces to the East
    Result: Karel is between waste cells and cleans it, moves back to corridor and looks to the East
 */
    private void cleanUpAndDown() throws Exception{
        if(noBeepersPresent()){
            turnLeft();
            move();
            cleanCell();
            turnAroundAndMoveToOppositeCell();
            cleanCell();
            backToCorridor();
        }
    }



    /*
        Precondition: Karel stays on trash
        Result: Karel picks up the trash
     */
    private void cleanCell() throws Exception{

        while(beepersPresent()){
            pickBeeper();
        }
    }

    /*
        Precondition: Karel steps in corridor
        Result: Karel skips walls and cleans cells
     */
    private void checksWallsInReactor() throws Exception {
        if(leftIsClear()){
            cleanUpAndDown();
        }
    }

    private void backToCorridor() throws Exception {
        turnAround();
        move();
        turnRight();
    }

    private void turnAroundAndMoveToOppositeCell() throws Exception {
        turnAround();
        move();
        move();
    }
}
