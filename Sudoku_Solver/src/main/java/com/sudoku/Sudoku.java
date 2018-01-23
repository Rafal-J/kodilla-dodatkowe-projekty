package com.sudoku;

import com.sudoku.board.Board;
import com.sudoku.board.Field;
import com.sudoku.game.*;

public class Sudoku {
    public static void main(String[] args) {
        System.out.println("ROZWIĄZYWARKA SUDOKU BY RJ");
        String choice = " ";
        Field[][] myBoard;
        while(!choice.equals("x")) {
            choice = UserChoice.startGame();
            if(!choice.equals("x")) {
                myBoard = Board.prepareBoard(choice);
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
                            if(Validator.validateSolution(myBoard) == Solution.COMPLETE) {
                                System.out.println("PRAWIDLOWE ROZWIĄZANIE");
                            }
                            else if(Validator.validateSolution(myBoard) == Solution.INCORRECT) {
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