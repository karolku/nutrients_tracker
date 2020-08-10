package com.karolk.util;

public class Round {
    public static double roundToTwoDecimal(double valueToBeRounded){
        return Math.round(valueToBeRounded * 100) / 100;
    }
}
