package com.sudoku.board;

import java.util.ArrayList;
import java.util.List;

public class BoardCollection {
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

        String[] board4 ={" 438 617 ",
                "5       2",
                " 9     6 ",
                "   4 8   ",
                " 2     5 ",
                "   1 3   ",
                " 7     4 ",
                "        8",
                " 356 972 "
        };

        String[] board5 = {"  43     ",
                "  7  5   ",
                "  3 9 218",
                " 2      3",
                "  8   6  ",
                "1      9 ",
                "596 3 8  ",
                "   8  1  ",
                "     24  "
        };

        String[] board6 = {"   7 9  5",
                "7  45  8 ",
                "4       7",
                "  5 91 2 ",
                "      6 1",
                " 49      ",
                "5  8     ",
                "6 7      ",
                "  1  2   "
        };

        String[] board7 = {"         ",
                "5  297   ",
                " 3 6   4 ",
                "   3  17 ",
                "      9  ",
                "41 96    ",
                "7   5 21 ",
                "     4  3",
                "  5     9"
        };

        String[] board8 = {"6  29    ",
                " 9       ",
                "     8  7",
                " 53  2   ",
                "8  35 9  ",
                " 7 96    ",
                " 28   5 6",
                "7 15     ",
                "   62    "
        };

        String[] board9 = {"  15 4 26",
                " 5    4 1",
                " 84216 53",
                "54 1   69",
                "168349572",
                " 2 6 5  4",
                "  5     8",
                " 9   1235",
                " 1 95 647"
        };

        boards.add(board1);
        boards.add(board2);
        boards.add(board3);
        boards.add(board4);
        boards.add(board5);
        boards.add(board6);
        boards.add(board7);
        boards.add(board8);
        boards.add(board9);

        return boards.get(selection - 1);
    }
}
