package com.sudoku.game;

import com.sudoku.board.Field;
import com.sudoku.methods.*;

public class SolveByLogic {
    public static Field[][] solveSudoku(Field[][] board){

        int totalPossibleNumbersQty;

        do {
            totalPossibleNumbersQty = Validator.countTotalPossibleNumbersQty(board);

            SmallSquareAnalyzer.analyze(board);
            ColumnAnalyzer.analyze(board);
            RowAnalyzer.analyze(board);
            NakedSingle.find(board);
            HiddenSingle.find(board);
            LockedCandidate.find(board);
            LockedPairs.find(board);
            } while(totalPossibleNumbersQty > Validator.countTotalPossibleNumbersQty(board));
        return board;
    }
}