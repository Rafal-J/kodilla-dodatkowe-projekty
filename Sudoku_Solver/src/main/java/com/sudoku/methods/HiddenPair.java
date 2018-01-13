package com.sudoku.methods;

import com.sudoku.board.Field;
import com.sudoku.myanotation.SudokuSolvingMethod;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

@SudokuSolvingMethod
public class HiddenPair implements SudokuMethod {
    public void solve(Field[][] board) {
        findHiddenPairsInRow(board);
        findHiddenPairsInColumn(board);
        findHiddenPairsInSquare(board);
    }

    private static void findHiddenPairsInRow(Field[][] board) {
        List<Field> data = new ArrayList<>();
        for (int r = 0; r < 9; r++) {
            }
            analyze(data);
        }

    private static void findHiddenPairsInColumn(Field[][] board) {
        List<Field> data = new ArrayList<>();
        for (int c = 0; c < 9; c++) {
            for (int r = 0; r < 9; r++) {
                data.add(board[r][c]);
            }
            analyze(data);
        }
    }

    private static void findHiddenPairsInSquare(Field[][] board) {
        List<Field> data = new ArrayList<>();

        for (int r1 = 0; r1 < 9; r1 = r1 + 3) {
            for (int c1 = 0; c1 < 9; c1 = c1 + 3) {
                for (int r2 = 0; r2 < 3; r2++) {
                    for (int c2 = 0; c2 < 3; c2++) {
                        data.add(board[r1 + r2][c1 + c2]);
                    }
                }
            }
                analyze(data);
            }
        }

    private static void analyze(List<Field> data) {
        List<List<String>> PAIRS = preparePairs();
        List<Field> finalData = new ArrayList<>();
        int counter;

        for (List<String> pair : PAIRS) {
            finalData.clear();
            counter = 0;
            for (Field field : data) {
                if (field.getPossibleNumbers().contains(pair.get(0)) != field.getPossibleNumbers().contains(pair.get(1))) {
                    counter = 0;
                    break;
                }

                if (field.getPossibleNumbers().contains(pair.get(0)) &&
                        field.getPossibleNumbers().contains(pair.get(1))) {
                    counter++;
                    finalData.add(field);
                }
            }

            if (counter == 2) {
                for (Field field : finalData) {
                    field.getPossibleNumbers().clear();
                    field.getPossibleNumbers().add(pair.get(0));
                    field.getPossibleNumbers().add(pair.get(1));
                }
                data.clear();
            }
        }
    }

    private static List<List<String>> preparePairs() {
        List<List<String>> PAIRS = new ArrayList<>();
        List<String> pair;

        for (Integer a = 1; a < 10; a++) {
            for (Integer b = a; b < 10; b++) {
                if (a != b) {
                    pair = new ArrayList<>();
                    pair.add(a.toString());
                    pair.add(b.toString());
                    PAIRS.add(pair);
                }
            }
        }
        return PAIRS;
    }

}
