package reviews;


import com.shpp.karel.KarelTheRobot;

public class Assignment1Part2 extends KarelTheRobot {
    public void run() throws Exception {
    runAround();
    checkForFacing();
    runAround();
    checkForFacing();
    runAround();
    checkForFacing();
    runAround();
    checkForFacing();
    runAround();
    }
    public void runAround() throws Exception {
    for( int i = 0; i <4; i++ ) {
        if(i == 2 && rightIsBlocked()){centerBipperCheck();}
        move();
        }
    }
    public void checkForFacing() throws Exception {
        if(facingEast() && frontIsBlocked()){
            turnLeft();
            move();
            turnLeft();
        }
        if(facingWest()&&frontIsBlocked()){
            turnRight();
        }
        if(facingNorth()&&frontIsClear()){
            move();
            turnRight();
        }
    }
    public void turnRight() throws Exception {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    public void centerBipperCheck() throws Exception {
        if(noBeepersPresent()){
            putBeeper();
        }
    }
}