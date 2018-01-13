package com.sudoku.game;

import com.sudoku.board.Board;
import com.sudoku.board.Field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    private static final String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static Solution validateSolution(Field[][] board, Field[][]... orgBoard) {
        if(isComplete(board)) {
            if(orgBoard.length > 0) {
                Board.deepCopyToOriginal(board, orgBoard[0]);
            }
            return Solution.COMPLETE;
        }
        if(isCorrect(board)) {
            return Solution.INCOMPLETE;
        }
        else {
            return Solution.INCORRECT;
        }
    }

    public static boolean isCorrect(Field[][] board) {
        Field number;
        for(int r = 0; r < 9; r++) {
            for(int c = 0; c < 9; c++) {
                number = board[r][c];
                if(number.getCorrectNumber().equals(" ") && number.getPossibleNumbers().size() == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isComplete(Field[][] board) {
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

    public static boolean validateColumns(Field[][] board) {
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

    public static boolean validateRows(Field[][] board) {
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

    public static int countTotalPossibleNumbersQty(Field[][] myBoard) {
        int sum = 0;
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                sum = sum + myBoard[r][c].getPossibleNumbers().size();
            }
        }
        return sum;
    }
}