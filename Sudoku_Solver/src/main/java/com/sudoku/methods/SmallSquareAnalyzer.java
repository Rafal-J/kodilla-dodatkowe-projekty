package com.sudoku.methods;

import com.sudoku.board.Number;

public class SmallSquareAnalyzer {
    private final static String EMPTY = " ";
    public static void analyze(Number[][] board){
        int smallSquareLeftUpperCornerR = 0;
        int smallSquareLeftUpperCornerC = 0;

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