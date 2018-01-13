package com.sudoku.methods;

import com.sudoku.board.Field;
import com.sudoku.myanotation.SudokuSolvingMethod;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

@SudokuSolvingMethod
public class LockedPairs implements SudokuMethod {

    public void solve(Field[][] board) {
        LockedPairs.findPairsInColumn(board);
        LockedPairs.findPairsInRow(board);
        LockedPairs.findPairsInSquare(board);
    }

    private static void findPairsInRow(Field[][] board) {
        List<Field> data = new ArrayList<>();
        for(int r = 0; r < 9; r++) {
            for(int c = 0; c < 9; c++) {
                data.add(board[r][c]);
            }
            analyze(data);
        }
    }

    private static void findPairsInColumn(Field[][] board) {
        List<Field> data = new ArrayList<>();
        for(int c = 0; c < 9; c++) {
            for(int r = 0; r < 9; r++) {
                data.add(board[r][c]);
            }
            analyze(data);
        }
    }

    private static void findPairsInSquare(Field[][] board) {
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

    private static void analyze(List<Field> data) {
        Pair<String, String> firstPair = new Pair<>(" ", " ");
        Pair<String, String> secondPair;

        for(int n = 0; n < 8; n++){
            if(data.get(n).getPossibleNumbers().size() == 2) {
                firstPair = new Pair(data.get(n).getPossibleNumbers().get(0), data.get(n).getPossibleNumbers().get(1));
            }
            for(int k = n + 1; k < 9; k++) {
                if(data.get(k).getPossibleNumbers().size() == 2) {
                    secondPair = new Pair(data.get(k).getPossibleNumbers().get(0), data.get(k).getPossibleNumbers().get(1));
                    if (firstPair.equals(secondPair)) {
                        data.remove(n);
                        data.remove(k-1);

                        for(int w = 0; w < data.size(); w++) {
                            data.get(w).getPossibleNumbers().remove(firstPair.getKey());
                            data.get(w).getPossibleNumbers().remove(firstPair.getValue());
                        }
                        data.clear();
                        return;
                    }
                }
            }
        }
        data.clear();
    }
}