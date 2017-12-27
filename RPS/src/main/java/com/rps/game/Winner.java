package com.rps.game;

public class Winner {
    public static void whoWins(int playerPoints, int computerPoints){
        if(playerPoints > computerPoints) {
            System.out.println("Gracz wygrał całą grę");
        }
        else if(playerPoints < computerPoints) {
            System.out.println("Komputer wygrał całą grę");
        }
        else{
            System.out.println("Gra zakończyła się remisem");
        }
    }
}
