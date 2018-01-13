package com.sudoku.game;

import com.sudoku.board.Field;

import java.util.ArrayList;
import java.util.List;

public class SolveByTrial {

    public static Solution findSolution(Field[][] deepCopyBoard, Field[][] originalBoard) {
        int[] nextTryCoordinates = findNextTry(deepCopyBoard);
        List<Field[][]> boards = prepareListOfPossibleTries(deepCopyBoard, nextTryCoordinates);
        Field[][] possibleSolution;
        Solution validation;

        for(int tryNumber = 0; tryNumber < boards.size(); tryNumber++) {
            possibleSolution = SolveByLogic.solveSudoku(boards.get(tryNumber));
            validation = Validator.validateSolution(possibleSolution, originalBoard);
            if(validation == Solution.INCOMPLETE) {
                validation = SolveByTrial.findSolution(possibleSolution, originalBoard);
                if(validation == Solution.COMPLETE) {
                    return Solution.COMPLETE;
                }
            }
        }
        return Solution.INCORRECT;
    }

    private static int[] findNextTry(Field[][] board) {
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

    private static List<Field[][]> prepareListOfPossibleTries(Field[][] board, int[] nextStepCoordinates) {
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
