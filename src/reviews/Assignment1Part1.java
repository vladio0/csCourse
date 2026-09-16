package reviews;

import com.shpp.karel.KarelTheRobot;

public class Assignment1Part1 extends KarelTheRobot {

    public void run() throws Exception {

        moveNorth();
        moveEast();
        moveSouth();
        moveEast();
        moveNorth();
        moveEast();
        moveSouth();
    }


    private void moveNorth() throws Exception {
        // Verification of the party's eligibility
        if (notFacingNorth()) {
            turnLeft();
        }

        for (int i = 0; i <= 5; i++) {

            // Checking if there is a beeper on the cell

            if (noBeepersPresent()) {
                say("Оу,біпер відсутній треба покласти");
                putBeeper();
            }

            // Checking whether there is a wall in front of us.

            if (frontIsClear()) {
                say("Чисто, можна рухатися далі");
                if (facingNorth()) {
                    move();
                }
            } else {
                turnLeft();
                turnLeft();
                turnLeft();
            }
        }
    }
    private void moveEast() throws Exception{

        for (int i = 0; i < 4; i++){
            if(facingEast()){move();}
        }

    }
    private void moveSouth() throws  Exception {
        if (notFacingSouth()) {
            turnLeft();
            turnLeft();
            turnLeft();
        }
        for (int i = 0; i <= 5; i++) {
            if (noBeepersPresent()) {
                say("Оу,біпер відсутній треба покласти");
                putBeeper();
            }
            if (frontIsClear()) {
                say("Чисто, можна рухатися далі");
                if (facingSouth()) {move();}
                if (frontIsBlocked() && leftIsClear()){turnLeft();}
            } else {say("Фініш");}
        }
    }
}