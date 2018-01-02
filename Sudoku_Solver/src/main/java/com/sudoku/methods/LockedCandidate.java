package com.sudoku.methods;

import com.sudoku.board.Number;

public class LockedCandidate {
    public static void findInSmallSquareInRow(Number[][] board) {
        Boolean foundNewCorrectNumber = true;
        Boolean notFound = true;
        int numberCounter = 0;
        int rowCounter = 0;
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
                                    numberCounter ++;
                                    row = r1 + r2;
                                }
                            }
                            if(numberCounter > 1) {
                                rowCounter++;
                            } else if(numberCounter == 1) {
                                notFound = true;
                            }
                            numberCounter = 0;
                        }
                        if(rowCounter == 1 && notFound == false) {
                            NumberEliminator.eliminateFromPartOfRow(board, number.toString(), row, c1);
                        }
                        rowCounter = 0;
                        notFound = false;
                    }

                }
            }
        }
    }
}
