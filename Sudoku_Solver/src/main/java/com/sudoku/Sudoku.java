package com.sudoku;

import com.sudoku.board.Board;
import com.sudoku.board.Field;
import com.sudoku.game.SolveByLogic;
import com.sudoku.game.SolveByTrial;
import com.sudoku.game.UserChoice;
import com.sudoku.game.Validator;

public class Sudoku {
    private static final int COMPLETE = 0;
    private static final int INCOMPLETE = 1;
    private static final int INCORRECT = 2;

    public static void main(String[] args) {
        System.out.println("ROZWIĄZYWARKA SUDOKU BY RJ");
        String choice = " ";
        Field[][] myBoard;
        while(!choice.equals("x")) {
            choice = UserChoice.startGame();
            if(!choice.equals("x")) {
                myBoard = Board.prepareBoard(Integer.parseInt(choice));
                System.out.println("START");
                Board.printBoard(myBoard);
                SolveByLogic.solveSudoku(myBoard);
                Board.printBoard(myBoard);
                switch (Validator.validateSolution(myBoard)) {
                    case COMPLETE: {
                        System.out.println("PRAWIDLOWE ROZWIĄZANIE");
                        break;
                }
                    case INCOMPLETE: {
                        System.out.println("ROZWIĄZANIE JEST NIEKOMPLETNE");
                        if (UserChoice.solveTrying().equals("t")) {
                            SolveByTrial.findSolution(myBoard, myBoard);
                            Board.printBoard(myBoard);
                            if(Validator.validateSolution(myBoard) == COMPLETE) {
                                System.out.println("PRAWIDLOWE ROZWIĄZANIE");
                            }
                            else if(Validator.validateSolution(myBoard) == INCORRECT) {
                                System.out.println("ROZWIĄZANIE JEST BLEDNE. PRAWDOPODOBNIE PLANSZA STARTOWA ZAWIERA BLAD I SUDOKU NIE MA ROZWIĄZANIA");
                            }
                        }
                        break;
                    }
                    case INCORRECT: {
                        System.out.println("ROZWIĄZANIE JEST BLEDNE. PRAWDOPODOBNIE PLANSZA STARTOWA ZAWIERA BLAD I SUDOKU NIE MA ROZWIĄZANIA");
                    }
                }
            }
        }
        System.out.println("GAME OVER");
    }
}