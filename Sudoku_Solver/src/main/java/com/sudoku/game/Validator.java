package com.sudoku.game;

import com.sudoku.board.Number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    private static final String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public static boolean validateSolution(Number[][] board) {
        boolean test = validateColumns(board);
        if(!test) {
            return test;
        }

        test = validateRows(board);
        if(!test) {
            return test;
        }

        return test;
    }

    public static boolean validateColumns(Number[][] board) {
        List<String> number;
        for(int r = 0; r < 9; r++) {
            number = new ArrayList<>(Arrays.asList(numbers));
            for(int c = 0; c < 9; c++) {
                number.remove(board[r][c].getCorrectNumber());
            }
            if(number.size() > 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateRows(Number[][] board) {
        List<String> number;
        for(int c = 0; c < 9; c++) {
            number = new ArrayList<>(Arrays.asList(numbers));
            for(int r = 0; r < 9; r++) {
                number.remove(board[r][c].getCorrectNumber());
            }
            if(number.size() > 0) {
                return false;
            }
        }
        return true;
    }

}
