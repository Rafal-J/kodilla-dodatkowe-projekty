package com.sudoku.board;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class Number {
    public String correctNumber;
    public List<String> possibleNumbers = new ArrayList<>();
    public String EMPTY = " ";

    public Number(String correctNumber) {
        this.correctNumber = correctNumber;
        if(correctNumber.equals(EMPTY)) {
            this.possibleNumbers = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        }
    }

}
