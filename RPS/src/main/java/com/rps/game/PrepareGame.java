package com.rps.game;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrepareGame {
    public static String getPlayerName() {
        boolean correctName = false;
        String correct = " ";
        Scanner scanner = new Scanner(System.in);
        String yourName;

        while (!correctName) {
            System.out.println("Graczu, podaj" + correct + "swoje imię:");
            yourName = scanner.nextLine();
            if (yourName.length() != 0) {
                return yourName;
            }
            System.out.println("Twoje imię musi składać się z przynajmniej jednego znaku");
            correct = " poprawnie ";
        }
        return "";
    }

    public static int getRoundsQty(String playerName) {
        boolean correctNumber = false;
        String correct = " ";
        int roundsQty;

        while (!correctNumber) {
            System.out.println(playerName + ", podaj" + correct + "ile rund chcesz rozegrać:\n" +
                    "(możesz podać wartości od 1 do 10)");
            roundsQty = getNumber();
            if (roundsQty > 0 && roundsQty < 11) {
                return roundsQty;
            }
            System.out.println("Podaj poprawną liczbę rund");
            correct = " poprawnie ";
        }
        return 1;
    }

    private static int getNumber(){
        Scanner scanner = new Scanner(System.in);
        int roundsQty;
        try {
            roundsQty = scanner.nextInt();
        } catch (InputMismatchException o) {
            roundsQty = 0;
        }
        return  roundsQty;
    }
}