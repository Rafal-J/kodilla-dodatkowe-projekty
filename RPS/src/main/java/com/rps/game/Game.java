package com.rps.game;

import java.util.*;

public class Game {
    private String playerName;
    private int roundsQty;

    public Game(String playerName, int roundsQty) {
        this.playerName = playerName;
        this.roundsQty = roundsQty;
    }

    public String startGame() {
        Instruction.printInstruction();

        String playerChoice = "", computerChoice = "";
        List<Integer> roundResult;
        int playerPoints = 0;
        int computerPoints = 0;

        for (int i = 1; i <= roundsQty; i++) {
            System.out.println("\nRUNDA " + i);

            playerChoice = KeyboardInput.playerChoice();

            if (playerChoice.equals("n") || playerChoice.equals("x")) {
                Winner.whoWins(playerPoints, computerPoints);
                Printer.printPoints(playerPoints, computerPoints, playerName);
                return playerChoice;
            }

            computerChoice = KeyboardInput.computerChoice();

            System.out.println("Wynik " + i + " rundy");
            Printer.printChoices(playerChoice, computerChoice);

            roundResult = RoundResult.whoWins(playerChoice, computerChoice);

            playerPoints = playerPoints + roundResult.get(0);
            computerPoints = computerPoints + roundResult.get(1);

            Printer.printPoints(playerPoints, computerPoints, playerName);
        }

        System.out.println("\nWYNIK KONCOWY");
        Winner.whoWins(playerPoints, computerPoints);
        Printer.printPoints(playerPoints, computerPoints, playerName);

        playerChoice = KeyboardInput.playAgain();

        return playerChoice;
    }
}