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
    //creating constants for Strings
    private static final String MINUTES = "How many minutes did you do on day %d ? ";
    private static final String MINUTES_GREATER = "Minutes must be greater than 0";
    private static final String CARDIO_HEALTH = "\nCardiovascular health:";
    private static final String BLOOD_PRESSURE = "Blood pressure:";
    private static final String CARDIO_HEALTH_CONCLUSION_TRUE = "   Great job! You've done enough exercise for cardiovascular health.";
    private static final String CARDIO_HEALTH_CONCLUSION_FALSE = "   You needed to train hard for at least %d more day(s) a week!";
    private static final String BLOOD_PRESSURE_CONCLUSION_TRUE = "   Great job! You've done enough exercise to keep a low blood pressure.";
    private static final String BLOOD_PRESSURE_CONCLUSION_FALSE = "   You needed to train hard for at least %d more day(s) a week!";
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
            int minutes = readInt(String.format(MINUTES, i));
            if (minutes < 0) {
                println(String.format(MINUTES_GREATER));
                return;
            }
            if (minutes >= MINS_FOR_CARDIOVASCULAR) {
                countCardioDays++;
            }
            if (minutes >= MINS_FOR_BLOOD_PRESSURE) {
                countPressureDays++;
            }
        }
        println(String.format(CARDIO_HEALTH));
        cardiovascularChecker(countCardioDays);
        println(String.format(BLOOD_PRESSURE));
        bloodPressureChecker(countPressureDays);
    }

    /*
        Comparing actual days of training for cardio with necessary
     */
    private void cardiovascularChecker(int count) {
        if (count >= DAYS_FOR_CARDIOVASCULAR) {
            println(String.format(CARDIO_HEALTH_CONCLUSION_TRUE));
        } else {
            println(String.format(CARDIO_HEALTH_CONCLUSION_FALSE, DAYS_FOR_CARDIOVASCULAR - count ));
        }
    }

    /*
        Comparing actual days of training for pressure with necessary
     */
    private void bloodPressureChecker(int count) {
        if (count >= DAYS_FOR_PRESSURE) {
            println(String.format(BLOOD_PRESSURE_CONCLUSION_TRUE));
        } else {
            println(String.format(BLOOD_PRESSURE_CONCLUSION_FALSE, DAYS_FOR_PRESSURE - count));
        }
    }
}


