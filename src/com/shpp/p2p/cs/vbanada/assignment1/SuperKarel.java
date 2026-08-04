package com.shpp.p2p.cs.vbanada.assignment1;

import com.shpp.karel.KarelTheRobot;
//I created super class for no copy and paste
public class SuperKarel extends KarelTheRobot {
    //making method to turn Karel right
    public void turnRight() throws Exception{
        turnLeft();
        turnLeft();
        turnLeft();
    }
    //making method to turn Karel around
    public void turnAround() throws Exception{
        turnLeft();
        turnLeft();
    }
}
