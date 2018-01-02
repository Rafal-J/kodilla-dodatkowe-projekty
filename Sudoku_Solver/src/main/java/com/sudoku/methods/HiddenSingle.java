package com.sudoku.methods;

import com.sudoku.board.Number;

public class HiddenSingle {
    public static void findInSmallSquare(Number[][] board) {
        Boolean foundNewCorrectNumber = true;
        int counter = 0;
        int column = 0;
        int row = 0;
        Number correctNumber = new Number(" ");

        while(foundNewCorrectNumber){
            foundNewCorrectNumber = false;
            for(Integer number = 1; number < 10; number ++) {
                for(int r1 = 0; r1 < 9; r1 = r1 + 3) {
                    for(int c1 = 0; c1 < 9; c1 = c1 +3) {
                        for(int r2 = 0; r2 < 3; r2++) {
                            for(int c2 = 0; c2 < 3; c2++) {
                                if(board[r1 + r2][c1 + c2].getPossibleNumbers().contains(number.toString())) {
                                    counter ++;
                                    correctNumber = board[r1 + r2][c1 + c2];
                                    row = r1 + r2;
                                    column = c1 + c2;
                                }
                            }
                        }
                        if(counter == 1) {
                            correctNumber.setCorrectNumber(number.toString());
                            correctNumber.getPossibleNumbers().clear();
                            NumberEliminator.eliminateFromColumn(board, number.toString(), column);
                            NumberEliminator.eliminateFromRow(board, number.toString(), row);
                        }
                        counter = 0;
                    }

                }
            }
        }
    }

    public static void findInRow(Number[][] board) {
        Boolean foundNewCorrectNumber = true;
        int counter = 0;
        int row = 0;
        int column = 0;
        Number correctNumber = new Number(" ");

        while(foundNewCorrectNumber){
            foundNewCorrectNumber = false;
            for(Integer number = 1; number < 10; number ++) {
                for(int r = 0; r < 9; r++) {
                    for(int c = 0; c < 9; c++) {
                        if(board[r][c].getPossibleNumbers().contains(number.toString())) {
                                    counter ++;
                                    correctNumber = board[r][c];
                                    row = r;
                                    column = c;
                        }
                    }
                    if(counter == 1) {
                        correctNumber.setCorrectNumber(number.toString());
                        correctNumber.getPossibleNumbers().clear();
                        NumberEliminator.eliminateFromColumn(board, number.toString(), column);
                        NumberEliminator.eliminateFromSmallSquare(board, number.toString(), row, column);
                    }
                    counter = 0;
                }
            }
        }
    }

    public static void findInColumn(Number[][] board) {
        Boolean foundNewCorrectNumber = true;
        int counter = 0;
        int row = 0;
        int column = 0;
        Number correctNumber = new Number(" ");

        while(foundNewCorrectNumber){
            foundNewCorrectNumber = false;
            for(Integer number = 1; number < 10; number ++) {
                for(int c = 0; c < 9; c++) {
                    for(int r = 0; r < 9; r++) {
                        if(board[r][c].getPossibleNumbers().contains(number.toString())) {
                            counter ++;
                            correctNumber = board[r][c];
                            row = r;
                            column = c;
                        }
                    }
                    if(counter == 1) {
                        correctNumber.setCorrectNumber(number.toString());
                        correctNumber.getPossibleNumbers().clear();
                        NumberEliminator.eliminateFromRow(board, number.toString(), row);
                        NumberEliminator.eliminateFromSmallSquare(board, number.toString(), row, column);
                    }
                    counter = 0;
                }
            }
        }
    }
}
