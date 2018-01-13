package com.sudoku.game;

import com.sudoku.board.Field;
import com.sudoku.methods.*;
import com.sudoku.myanotation.SudokuSolvingMethod;
import org.reflections.Reflections;

import java.util.Iterator;
import java.util.Set;


public class SolveByLogic {
    public static Field[][] solveSudoku(Field[][] board){

        int totalPossibleNumbersQty;

        do {
            totalPossibleNumbersQty = Validator.countTotalPossibleNumbersQty(board);

            useAllMethods(board);

            } while(totalPossibleNumbersQty > Validator.countTotalPossibleNumbersQty(board));
        return board;
    }

    public static void useAllMethods(Field[][] board) {
        SmallSquareAnalyzer square = new SmallSquareAnalyzer();
        ColumnAnalyzer column = new ColumnAnalyzer();
        RowAnalyzer row = new RowAnalyzer();

        Reflections reflections = new Reflections("com.sudoku");
        Set<Class<?>> methodsSolvingSudoku = reflections.getTypesAnnotatedWith(SudokuSolvingMethod.class);


        SudokuMethod sudokuMethod;

        Iterator<Class<?>> iterator = methodsSolvingSudoku.iterator();
        while (iterator.hasNext()) {
            square.solve(board);
            column.solve(board);
            row.solve(board);
            try {
                sudokuMethod = (SudokuMethod) iterator.next().newInstance();
                sudokuMethod.solve(board);
            } catch (IllegalAccessException | InstantiationException a) {
                System.out.println("Wystąpił wyjątek");
            }
        }
    }
}