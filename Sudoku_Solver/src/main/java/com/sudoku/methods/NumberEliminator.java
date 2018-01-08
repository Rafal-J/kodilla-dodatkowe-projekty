package com.sudoku.methods;
import com.sudoku.board.Field;

public class NumberEliminator {
    public static void eliminateFromSmallSquare(Field[][] board, String number, int row, int column) {
        int smallSquareLeftUpperCornerR = row - row % 3;
        int smallSquareLeftUpperCornerC = column - column % 3;
        for (int r = 0 + smallSquareLeftUpperCornerR; r < 3 + smallSquareLeftUpperCornerR; r++) {
            for (int c = 0 + smallSquareLeftUpperCornerC; c < 3 + smallSquareLeftUpperCornerC; c++) {
                if (board[r][c].getPossibleNumbers().contains(number)) {
                    board[r][c].getPossibleNumbers().remove(number);
                }
            }
        }
    }

    public static void eliminateFromRow(Field[][] board, String number, int row) {
        for (int i = 0; i < 9; i++) {
            board[row][i].getPossibleNumbers().remove(number);
        }
    }

    public static void eliminateFromColumn(Field[][] board, String number, int column) {
        for (int r = 0; r < 9; r++) {
            board[r][column].getPossibleNumbers().remove(number);
        }
    }

    public static void eliminateFromPartOfRow(Field[][] board, String number, int row, int column) {
        for (int c = 0; c < 9; c++) {
            if (c < column || c > column + 2) {
                board[row][c].getPossibleNumbers().remove(number);
            }
        }
    }

    public static void eliminateFromPartOfColumn(Field[][] board, String number, int column, int row) {
        for (int r = 0; r < 9; r++) {
            if (r < row || r > row + 2) {
                board[r][column].getPossibleNumbers().remove(number);
            }
        }
    }
}

