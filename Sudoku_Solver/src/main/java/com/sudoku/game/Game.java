package com.sudoku.game;

import com.sudoku.board.Board;
import com.sudoku.board.Number;
import com.sudoku.methods.*;

public class Game {
    public static void solveSudoku(){
        Number[][] myBoard = Board.prepareBoard(4);
        System.out.println("START");

        for(int i = 0; i < 24; i++) {
            SmallSquareAnalyzer.analyze(myBoard);
            ColumnAnalyzer.analyze(myBoard);
            RowAnalyzer.analyze(myBoard);

            HiddenSingle.findInRow(myBoard);
            HiddenSingle.findInColumn(myBoard);
            HiddenSingle.findInSmallSquare(myBoard);
            NakedSingle.find(myBoard);
            LockedCandidate.findInSmallSquareInRow(myBoard);
            //System.out.println(Validator.validateSolution(myBoard));
        }

        Board.printBoard(myBoard);
        System.out.println();
       // LockedCandidate.findInSmallSquareInRow(myBoard);

        for(int i = 0; i < 24; i++) {
            SmallSquareAnalyzer.analyze(myBoard);
            ColumnAnalyzer.analyze(myBoard);
            RowAnalyzer.analyze(myBoard);

            HiddenSingle.findInRow(myBoard);
            HiddenSingle.findInColumn(myBoard);
            HiddenSingle.findInSmallSquare(myBoard);
            NakedSingle.find(myBoard);

            //System.out.println(Validator.validateSolution(myBoard));
        }
        Board.printBoard(myBoard);
        Board.testPrint(myBoard);
    }
}
