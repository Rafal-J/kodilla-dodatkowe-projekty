package com.rps.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoundResult {
    private static final ArrayList<String> playerWon = new ArrayList<>(Arrays.asList("12","23","34", "45", "51", "14", "25", "31", "42", "53"));

    public static List<Integer> whoWins(String playerChoice, String computerChoice){
        List<Integer> points = new ArrayList<>();
        String choices = playerChoice + computerChoice;
        if(playerChoice.equals(computerChoice)){
            points.add(0);
            points.add(0);
            System.out.println("Runda zakończyła się remisem!");
        }
        else if(playerWon.contains(choices)) {
            points.add(1);
            points.add(0);
            System.out.println("Gracz wygrał rundę!");
        }
        else {
            points.add(0);
            points.add(1);
            System.out.println("Komputer wygrał rundę!");
        }
        return points;
    }

}
