package com.shpp.p2p.cs.vbanada.assignment3;

import com.shpp.cs.a.console.TextProgram;

/*
    Program - aerobic
 */

public class Assignment3Part1 extends TextProgram {
    //days in a one week
    private static final int DAYS = 7;
    //minutes per day need to exercise for cardiovascular health
    private static final int MINS_FOR_CARDIOVASCULAR = 30;
    //days per week need to exercise for cardiovascular health
    private static final int DAYS_FOR_CARDIOVASCULAR = 5;
    //minutes per day need to exercise to keep a low blood pressure
    private static final int MINS_FOR_BLOOD_PRESSURE = 40;
    //days per week need to exercise to keep a low blood pressure
    private static final int DAYS_FOR_PRESSURE = 3;

    /*
        1.Creating counters that count actual days of training
        2.Crating loop to enter minutes of training per day
        3.Comparing actual minutes of each day with necessary for each case
        4.Checking the final result
     */
    @Override
    public void run() {
        int countCardioDays = 0;
        int countPressureDays = 0;
        for (int i = 1; i <= DAYS; i++) {
            int min = readInt("How many minutes did you do on day " + i + "? ");
            if(min < 0){
                println("Minutes must be greater than 0");
                return;
            }
            else{
                if (min >= MINS_FOR_CARDIOVASCULAR) {
                    countCardioDays++;
                }
                if (min >= MINS_FOR_BLOOD_PRESSURE) {
                    countPressureDays++;
                }
            }
        }
        println("Cardiovascular health:");
        cardiovascularChecker(countCardioDays);
        println("Blood pressure:");
        bloodPressureChecker(countPressureDays);
    }

    /*
        Comparing actual days of training for cardio with necessary
     */
    private void cardiovascularChecker(int count) {
        if (count >= DAYS_FOR_CARDIOVASCULAR) {
            println("Great job! You've done enough exercise for cardiovascular health.");
        } else {
            println("You needed to train hard for at least " + (DAYS_FOR_CARDIOVASCULAR - count) + " more day(s) a week!");
        }
    }

    /*
        Comparing actual days of training for pressure with necessary
     */
    private void bloodPressureChecker(int count) {
        if (count >= DAYS_FOR_PRESSURE) {
            println("Great job! You've done enough exercise to keep a low blood pressure.");
        } else {
            println("You needed to train hard for at least " + (DAYS_FOR_PRESSURE - count) + " more day(s) a week!");
        }
    }
}


