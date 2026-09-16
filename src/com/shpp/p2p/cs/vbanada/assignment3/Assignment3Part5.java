package com.shpp.p2p.cs.vbanada.assignment3;

import acm.util.RandomGenerator;
import com.shpp.cs.a.console.TextProgram;

/*
    Program "Casino Bernoulli"
 */
public class Assignment3Part5 extends TextProgram {
    //Constant of target bank sum
    private static final int TARGET_BANK = 20;
    /* Random generator instance for simulating coin flips */
    private final RandomGenerator coinFlip = RandomGenerator.getInstance();
    /*
            Creating counters to count amount of money on table, how much money Lucky has;
            Counting games and playing casino
            Printing how many games it took to earn 20 dollars
     */
    @Override
    public void run() {
        int countGames = game();
        println("It took " + countGames + " games to earn $" + TARGET_BANK);
    }

    /*
        Casino game cycle:
        - Each game starts with $1 on the table.
        - Lucky flips a coin with 50% chance each side:
            OREL (0): money on the table doubles.
            RESHKA (1): round ends, Lucky collects all money from the table.
        - Repeats until Lucky's total earnings reach TARGET_BANK.
     */
    private int game() {
        int luckyBank = 0;
        int countGames = 0;

        while (luckyBank < TARGET_BANK) {
            int sumOnTable = 1;
            while (coinFlip.nextBoolean(0.5)) {
                sumOnTable *= 2;
            }
            luckyBank += sumOnTable;
            countGames++;
            println("This game, you earned $" + sumOnTable);
            println("Your total is $" + luckyBank);

        }
        return countGames;
    }
}

