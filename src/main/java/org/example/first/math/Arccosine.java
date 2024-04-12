package org.example.first.math;

import lombok.AllArgsConstructor;
import lombok.val;
import java.lang.Math.*;

@AllArgsConstructor
public class Arccosine {

    private final static int VERY_BIG_NUMBER = 70;

    public double calculate(double x){
        if (Double.isNaN(x)){
            throw new IllegalArgumentException("Argument must be a number");
        }
        if (Double.isInfinite(x) || x>1 || x<-1){
            throw new IllegalArgumentException("Argument must be in [-1;1] section");
        }
        double result = 0;
        double factorial = 1;
        double doubleFactorial = 1;
        int k =1;
        double xPowered = x;
        double fourPowered=1;

        for (int i = 0; i < VERY_BIG_NUMBER; i++) {
            if (i!=0){
                factorial *= i;
                doubleFactorial *= (2*i-1)*(2*(i));
            }
            result += (doubleFactorial*xPowered)/(fourPowered*(factorial*factorial)*(2*i+1));
            xPowered*=xPowered*xPowered;
            fourPowered*=4;
        }
        return Math.PI/2 - result;
    }

    public double calculateWithMath(double x){
        return Math.acos(x);
    }



}
