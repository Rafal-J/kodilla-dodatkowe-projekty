package com.sudoku.board;

public class Board {
    public static Number[][] prepareBoard(int selection) {
        /*String[] textBoard = {"8   1   9",
                " 5 8 7 1 ",
                "  4 9 7  ",
                " 6 7 1 2 ",
                "5 8 6 1 7",
                " 1 5 2 9 ",
                "  7 4 6  ",
                " 8 3 9 4 ",
                "3   5   8"
        };*/

        String[] textBoard = SudokuCollection.getBoard(selection);

        Boolean boardValidator = true;
        for (int i = 0; i < textBoard.length; i++) {
            if (textBoard[i].length() != 9) {
                boardValidator = false;
                i++;
                System.out.println("Problem z " + i + ". wierszem.\n" +
                        "Długość wiersza: " + textBoard[i - 1].length());
                break;
            }
        }

        Number[][] board = new Number[9][9];
        Number number;
        for (int i = 0; i < 9; i++) {
            for (int k = 0; k < 9; k++) {
                number = new Number(textBoard[i].substring(k, k + 1));
                board[i][k] = number;
            }
        }

        return board;
    }

    public static void printBoard(Number[][] board) {
        String[][] printedBoard = new String[13][13];

        for (int i = 0; i < 13; i = i + 4) {
            for (int k = 0; k < 13; k++) {
                printedBoard[i][k] = "-";
            }
        }

        for (int i = 0; i < 13; i = i + 4) {
            for (int k = 0; k < 13; k++) {
                printedBoard[k][i] = "|";
            }
        }

        int x = 0;
        int y = 0;

        for (int i = 0; i < 13; i++) {
            for (int k = 0; k < 13; k++) {
                if (printedBoard[i][k] == null) {
                    System.out.print(board[y][x].getCorrectNumber());
                    x++;
                } else {
                    System.out.print(printedBoard[i][k]);
                }
            }
            if (x > 0) {
                y++;
            }
            x = 0;
            System.out.println();
        }
        System.out.println();
    }

    public static void testPrint(Number[][] myBoard) {
        for (int r = 0; r < 1; r++) {
            for (int c = 7; c < 9; c++) {
                // if(myBoard[i][k].getCorrectNumber().equals(" ")) {
                System.out.print("xy: " + (r + 1) + "" + (c + 1) + " " + myBoard[r][c].getCorrectNumber() + " - ");
                for (int d = 0; d < myBoard[r][c].getPossibleNumbers().size(); d++) {
                    System.out.print(myBoard[r][c].getPossibleNumbers().get(d));
                }
                // }
                //  if(myBoard[i][k].getCorrectNumber().equals(" ")) {
                System.out.println();
                // }
            }
        }
    }

    public static void printClearBoard(Number[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int k = 0; k < 9; k++) {
                System.out.print(board[k][i].getCorrectNumber());
            }
            System.out.println();
        }
    }
}