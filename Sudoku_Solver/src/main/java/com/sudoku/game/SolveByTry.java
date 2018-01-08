package com.sudoku.game;


import com.sudoku.board.Field;

import java.util.ArrayList;
import java.util.List;

public class SolveByTry {
    private static final int COMPLETE = 0;
    private static final int INCOMPLETE = 1;
    private static final int INCORRECT = 2;
    private static final int UNKNOWN = 3;

    public static int findSolution(Field[][] deepCopyBoard, Field[][] originalBoard) {
        int[] nextTryCoordinates = findNextTry(deepCopyBoard);
        List<Field[][]> boards = prepareListOfPossibleTries(deepCopyBoard, nextTryCoordinates);

        Field[][] possibleSolution = new Field[9][9];
        int validation = UNKNOWN;

        for(int tryNumber = 0; tryNumber < boards.size(); tryNumber++) {
            possibleSolution = SolveByLogic.solveSudoku(boards.get(tryNumber));
            validation = Validator.validateSolution(possibleSolution, originalBoard);
            if(validation == INCOMPLETE) {
                validation = SolveByTry.findSolution(possibleSolution, originalBoard);
                if(validation == COMPLETE) {
                    return COMPLETE;
                }
                else if(validation == INCORRECT) {
                    continue;
                }
            }
        }
        return INCORRECT;
    }

    public static int[] findNextTry(Field[][] board) {
        for(int possibleNumbersQty = 2; possibleNumbersQty < 10; possibleNumbersQty ++) {
            for(int r = 0; r < 9; r++) {
                for(int c = 0; c < 9; c++) {
                    if(board[r][c].possibleNumbers.size() == possibleNumbersQty) {
                        int[] coordinates = {r, c};
                        return coordinates;
                    }
                }
            }
        }

        int[] doesntMatter = {10, 10};
        return doesntMatter;
    }

    public static List<Field[][]> prepareListOfPossibleTries(Field[][] board, int[] nextStepCoordinates) {
        Field nextStep = board[nextStepCoordinates[0]][nextStepCoordinates[1]];
        List<Field[][]> boards = new ArrayList<>();

        for(int boardNumber = 0; boardNumber < nextStep.getPossibleNumbers().size(); boardNumber++) {
            boards.add(new Field[9][9]);
            for(int c = 0; c < 9; c++) {
                for(int r = 0; r < 9; r++) {
                    boards.get(boardNumber)[c][r] = new Field(board[c][r].getCorrectNumber());
                    if(c == nextStepCoordinates[0] && r == nextStepCoordinates[1]){
                        boards.get(boardNumber)[c][r] = new Field(board[c][r].getPossibleNumbers().get(boardNumber));
                    }
                }
            }
        }
        return boards;
    }
}
