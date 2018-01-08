package com.sudoku.board;

public class Board {
    public static Field[][] prepareBoard(int choice) {
        String[] textBoard = new String[9];
        if(choice == 0) {
            textBoard = UserBoard.prepareBoard();
        }
        else {
            textBoard = BoardCollection.getBoard(choice);
        }

        Field[][] board = new Field[9][9];
        Field number;
        for (int i = 0; i < 9; i++) {
            for (int k = 0; k < 9; k++) {
                number = new Field(textBoard[i].substring(k, k + 1));
                board[i][k] = number;
            }
        }

        return board;
    }

    public static void printBoard(Field[][] board) {
        String[][] printedBoard = new String[13][13];

        for (int r = 0; r < 13; r = r + 4) {
            for (int c = 0; c < 13; c++) {
                printedBoard[r][c] = "-";
            }
        }

        for (int c = 0; c < 13; c = c + 4) {
            for (int r = 1; r < 12; r++) {
                printedBoard[r][c] = "|";
            }
        }

        int x = 0;
        int y = 0;

        for (int i = 0; i < 13; i++) {
            for (int k = 0; k < 13; k++)

            {
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

    public static void deepCopyToOriginal(Field[][] deepCopyBoard, Field[][] originalBoard) {
        for(int r = 0; r < 9; r++) {
            for(int c = 0; c < 9; c++) {
                originalBoard[r][c].setCorrectNumber(deepCopyBoard[r][c].getCorrectNumber());
                originalBoard[r][c].getPossibleNumbers().clear();
            }
        }
    }

    public static void testPrint(Field[][] myBoard) {
        int sum = 0;
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                // if(myBoard[i][k].getCorrectNumber().equals(" ")) {
                /*System.out.print("xy: " + (r + 1) + "" + (c + 1) + " " + myBoard[r][c].getCorrectNumber() + " - ");
                for (int d = 0; d < myBoard[r][c].getPossibleNumbers().size(); d++) {
                    System.out.print(myBoard[r][c].getPossibleNumbers().get(d));
                }*/
                // }
                //  if(myBoard[i][k].getCorrectNumber().equals(" ")) {
                //System.out.println();
                // }
                sum = sum + myBoard[r][c].getPossibleNumbers().size();
            }
        }
        System.out.println(sum);
    }
}