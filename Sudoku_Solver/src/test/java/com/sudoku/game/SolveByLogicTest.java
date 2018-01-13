package com.sudoku.game;

import com.sudoku.board.Field;
import org.junit.Test;

public class SolveByLogicTest {
    @Test
    public void refTest() throws InstantiationException, IllegalAccessException {
        Field[][] board = new Field[9][9];
      SolveByLogic.useAllMethods(board);
    }

}
