package com.shpp.p2p.cs.vbanada.assignment1;
/*
    Program in which Karel cleans nuclear reactor
 */
public class Assignment1Part4 extends SuperKarel{
    /*
        Precondition: Karel stays at the start of reactor
        Result: Karel went through reactor and cleaned trash
     */
    @Override
    public void run() throws Exception {
        /*
            to avoid problem with forgetting the last step
                after cycle checking process one more time
         */
        while(frontIsClear()){
            checkWallsAndClean();
            move();
        }
        checkWallsAndClean();

    }
/*
    Precondition: Karel stands in corridor, faces to the East
    Result: Karel is between waste cells and cleans it, moves back to corridor and looks to the East
 */
    private void cleanUpAndDown() throws Exception{
        //turn left, and clean upper cell at first
            turnLeft();
            move();

            cleanCell();

            //turn around - clean lower cell
            turnAround();
            move();
            move();

            cleanCell();

            //comes back to corridor and looks to the East
            turnAround();
            move();
            turnRight();
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
    private void checkWallsAndClean() throws Exception {
        if(leftIsClear()){
            cleanUpAndDown();
        }
    }
}
