package com.sudoku.board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserBoard {
    private static final List<String> CORRECTCHOICE = new ArrayList<>(Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", " "));
    public static String[] prepareBoard() {
        String[] board = new String[9];
        String row = " ";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Własne Sudoku do rozwiązania należy wprowadzać całymi wierszami.\n" +
                "Każdy wiersz musi składać się z 9 znaków - liczb od 1 do 9 oraz spacji w miejscu pustych pól");

        for (int r = 0; r < 9; r++) {
            System.out.println("Wprowadź wiersz " + (r + 1));
            while (0 < 1) {
                row = scanner.nextLine();
                if(check(row)) {
                    board[r] = row;
                    break;
                }
                System.out.println("Wprowadszono błędne dane. Spróbuj jeszcze raz.");
            }

        }
        return board;
    }

    public static boolean check(String row) {
        if(row.length() != 9) {
            return false;
        }

        for(int c = 0; c < 9; c++) {
            if(!CORRECTCHOICE.contains(row.substring(c, c+1))) {
                return false;
            }
        }

        return true;
    }
}