package reviews;
import com.shpp.karel.KarelTheRobot;


public class Assignment1Part3 extends KarelTheRobot{
    public void run()throws Exception {
    twoBippersPut();
    checkForFacing();
    oneBippersPut();
    checkForFacing();
    twoBippersPut();;
    checkForFacing();
    oneBippersPut();
    }
    public void twoBippersPut()throws Exception{
        for (int i = 0; i<=3;i++){
        if(noBeepersPresent() && i==0 || i==3){putBeeper();}
        if(frontIsClear()){move();}
        }
    }
    public void oneBippersPut()throws Exception{
        for (int i = 0; i < 3; i++){
            if(noBeepersPresent() && i==1){putBeeper();}
            if(frontIsClear()){move();}
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
}
