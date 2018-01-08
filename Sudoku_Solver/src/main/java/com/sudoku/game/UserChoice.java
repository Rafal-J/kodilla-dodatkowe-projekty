package com.sudoku.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserChoice {
    private static final List<String> CORRECTCHOICE = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8","x"));
    private static final List<String> YESORNO = new ArrayList<>(Arrays.asList("t", "n"));

    public static String startGame() {
        Scanner scanner = new Scanner(System.in);
        String choice = " ";
        System.out.println("----------\n" +
                "Co chcesz zrobić?");
        while(0 < 1) {
            System.out.println("Aby rozwiązać istniejące Sudoku, wybierz cyfrę od 1 do 8\n" +
            "Aby wprowadzić własne Sudoku, wybierz 0\n" +
            "Aby zakończyć grę, wybierz x");
            choice = scanner.nextLine();
            if(CORRECTCHOICE.contains(choice)) {
                return choice;
            }
            System.out.println("Błędny wybór! Spróbuj jeszcze raz.");
        }

    }

    public static String solveTrying() {
        Scanner scanner = new Scanner(System.in);
        String choice = " ";
        System.out.println("----------\n");
        while(0 < 1) {
            System.out.println("Czy chcesz znaleźć rozwiązanie metodą prób i błędów?(t/n)");
            choice = scanner.nextLine();
            if(YESORNO.contains(choice)) {
                return choice;
            }
            System.out.println("Błędny wybór! Spróbuj jeszcze raz.");
        }
    }
}
