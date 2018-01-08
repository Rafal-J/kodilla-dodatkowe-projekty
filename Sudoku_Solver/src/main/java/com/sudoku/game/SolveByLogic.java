package com.sudoku.game;

import com.sudoku.board.Field;
import com.sudoku.methods.*;

public class SolveByLogic {
    public static Field[][] solveSudoku(Field[][] board){

        int totalPossibleNumbersQty = 0;

        while(0 < 1) {
            totalPossibleNumbersQty = Validator.countTotalPossibleNumbersQty(board);

            SmallSquareAnalyzer.analyze(board);
            ColumnAnalyzer.analyze(board);
            RowAnalyzer.analyze(board);
            NakedSingle.find(board);
            HiddenSingle.find(board);
            LockedCandidate.find(board);
            LockedPairs.find(board);

            if(totalPossibleNumbersQty == Validator.countTotalPossibleNumbersQty(board)) {
                break;
            }
        }
        return board;
    }
}