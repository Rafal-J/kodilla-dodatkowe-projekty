package com.sudoku.methods;

import com.sudoku.board.Field;

import java.util.ArrayList;
import java.util.List;

public class LockedPairs {
    public static void find(Field[][] board) {
        LockedPairs.findPairInColumn(board);
        LockedPairs.findPairInRow(board);
        LockedPairs.findPairInSquare(board);
    }

    public static void findPairInRow(Field[][] board) {
        List<Field> data = new ArrayList<>();
        for(int r = 0; r < 9; r++) {
            for(int c = 0; c < 9; c++) {
                data.add(board[r][c]);
            }
            analyze(data);
        }
    }

    public static void findPairInColumn(Field[][] board) {
        List<Field> data = new ArrayList<>();
        for(int c = 0; c < 9; c++) {
            for(int r = 0; r < 9; r++) {
                data.add(board[r][c]);
            }
            analyze(data);
        }
    }

    public static void findPairInSquare(Field[][] board) {
        List<Field> data = new ArrayList<>();

        for (int r1 = 0; r1 < 9; r1 = r1 + 3) {
            for (int c1 = 0; c1 < 9; c1 = c1 + 3) {
                for (int r2 = 0; r2 < 3; r2++) {
                    for (int c2 = 0; c2 < 3; c2++) {
                        data.add(board[r1 + r2][c1 + c2]);
                    }
                }
                analyze(data);
            }
        }
    }

     public static void analyze(List<Field> data) {
        String firstPair = " ";
        String secondPair = "  ";
        String firstNumber = " ";
        String secondNumber = " ";

        for(int n = 0; n < 8; n++){
            if(data.get(n).getPossibleNumbers().size() == 2) {
                firstPair = data.get(n).getPossibleNumbers().get(0) + data.get(n).getPossibleNumbers().get(1);
            }
            for(int k = n + 1; k < 9; k++) {
                if(data.get(k).getPossibleNumbers().size() == 2) {
                    secondPair = data.get(k).getPossibleNumbers().get(0) + data.get(k).getPossibleNumbers().get(1);
                    if (firstPair.equals(secondPair)) {
                        firstNumber = firstPair.substring(0,1);
                        secondNumber = firstPair.substring(1,2);
                        data.remove(n);
                        data.remove(k-1);

                        for(int w = 0; w < data.size(); w++) {
                            data.get(w).getPossibleNumbers().remove(firstNumber);
                            data.get(w).getPossibleNumbers().remove(secondNumber);
                        }
                        data.clear();
                        return;
                    }
                }
            }
            firstPair = " ";
            secondPair = "  ";
        }
        data.clear();
    }
}