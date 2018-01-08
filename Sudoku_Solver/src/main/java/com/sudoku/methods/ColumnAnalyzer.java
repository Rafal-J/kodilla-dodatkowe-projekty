package com.sudoku.methods;

import com.sudoku.board.Field;

public class ColumnAnalyzer {
    public static final String EMPTY = " ";

    public static void analyze(Field[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (!board[r][c].getCorrectNumber().equals(EMPTY)) {
                    NumberEliminator.eliminateFromColumn(board, board[r][c].getCorrectNumber(), c);
                }
            }

        }
    }
}
