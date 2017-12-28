package com.rps;

import com.rps.game.Game;
import com.rps.game.PrepareGame;

public class RPSRunner {
    public static void main(String[] args){
        System.out.println("Papier-Kamień-Nożyczki (2017)\n" +
        "wersja rozszerzona");
        Game game;
        String status = "";
        String playerName;
        int roundsQty;
        while(!status.equals("x")){
            System.out.println("---NOWA GRA---");
            playerName = PrepareGame.getPlayerName();
            roundsQty = PrepareGame.getRoundsQty(playerName);
            status = "";
            while(!status.equals("x") && !status.equals("n")) {
                game = new Game(playerName, roundsQty);
                status = game.startGame();
            }
        }
        System.out.println("Do zobaczenia!!!");
    }

}
