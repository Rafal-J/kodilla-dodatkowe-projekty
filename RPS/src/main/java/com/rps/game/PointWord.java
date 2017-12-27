package com.rps.game;

public class PointWord {
    public static String chooseRightWord(int pointsQty) {

        String pointWord = "punktów";

        if(pointsQty == 1 ) {
            pointWord = "punkt";
        }
        else if(pointsQty%10 > 1 && pointsQty%10 < 5) {
            pointWord = "punkty";
        }
        return pointWord;
    }
}
