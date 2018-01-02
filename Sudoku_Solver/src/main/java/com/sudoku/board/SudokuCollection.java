package com.sudoku.board;

import java.util.ArrayList;
import java.util.List;

public class SudokuCollection {
    public static String[] getBoard(int selection) {

        List<String[]> boards = new ArrayList<>();

        String[] board1 = {"8   1   9",
                " 5 8 7 1 ",
                "  4 9 7  ",
                " 6 7 1 2 ",
                "5 8 6 1 7",
                " 1 5 2 9 ",
                "  7 4 6  ",
                " 8 3 9 4 ",
                "3   5   8"
        };

        String[] board2 = {"  2 4 6  ",
                " 5  8  2 ",
                "4  5 9  3",
                "  3   5  ",
                "72  9  68",
                "  1   4  ",
                "3  2 7  5",
                " 6  5  8 ",
                "  7 1 2  "
        };

        String[] board3 = {"  7      ",
                "  92  4  ",
                " 6  73 21",
                "  83 5 6 ",
                "  3   9  ",
                " 4 7 15  ",
                "27 63  5 ",
                "  1  83  ",
                "      2  "
        };

        String[] board4 = {"  43     ",
                "  7  5   ",
                "  3 9 218",
                " 2      3",
                "  8   6  ",
                "1      9 ",
                "596 3 8  ",
                "   8  1  ",
                "     24  "

        };

        boards.add(board1);
        boards.add(board2);
        boards.add(board3);
        boards.add(board4);

        return boards.get(selection - 1);
    }
}
