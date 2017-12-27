package com.rps.game;

import java.util.ArrayList;
import java.util.Arrays;

public class Printer {
    public static void printChoices(String playerChoice, String computerChoice) {
        ArrayList<String> possibleChoices = new ArrayList<>(Arrays.asList("kamień","papier", "nożyczki"));
        System.out.println("Gracz wybrał: " + possibleChoices.get(Integer.parseInt(playerChoice)-1));
        System.out.println("Komputer wybrał: " + possibleChoices.get(Integer.parseInt(computerChoice)-1));
    }

    public static void printPoints(int playerPoints, int computerPoints, String playerName) {
        System.out.println(playerName + ": " + playerPoints + " " + PointWord.chooseRightWord(playerPoints) + ".");
        System.out.println("Komputer: " + computerPoints + " " + PointWord.chooseRightWord(computerPoints) + ".");
    }
}
