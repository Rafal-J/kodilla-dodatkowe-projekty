package com.sudoku.methods;

import com.sudoku.board.Field;
import com.sudoku.myanotation.SudokuSolvingMethod;

public class SmallSquareAnalyzer implements SudokuMethod {
    private final static String EMPTY = " ";

    public void solve(Field[][] board){

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++){
                if(!board[r][c].getCorrectNumber().equals(EMPTY)){
                    NumberEliminator.eliminateFromSmallSquare(board, board[r][c].getCorrectNumber(),
                            r, c);
                }
            }
        }
    }
}