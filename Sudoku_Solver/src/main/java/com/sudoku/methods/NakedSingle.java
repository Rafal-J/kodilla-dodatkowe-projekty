package com.sudoku.methods;

import com.sudoku.board.Field;
import com.sudoku.myanotation.SudokuSolvingMethod;

@SudokuSolvingMethod
public class NakedSingle implements SudokuMethod{
    public void solve(Field[][] board) {
        String correctNumber = " ";
        Boolean foundNewCorrectNumber = true;

        while (foundNewCorrectNumber) {
            foundNewCorrectNumber = false;
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    if (board[r][c].getPossibleNumbers().size() == 1) {
                        foundNewCorrectNumber = true;
                        correctNumber = board[r][c].getPossibleNumbers().get(0);
                        board[r][c].setCorrectNumber(correctNumber);
                        board[r][c].getPossibleNumbers().clear();
                        NumberEliminator.eliminateFromRow(board, correctNumber, r);
                        NumberEliminator.eliminateFromColumn(board, correctNumber, c);
                        NumberEliminator.eliminateFromSmallSquare(board, correctNumber, r, c);
                    }
                }
            }
        }
    }
}