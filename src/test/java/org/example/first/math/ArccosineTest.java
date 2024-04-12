package org.example.first.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;



class ArccosineTest {

    Arccosine arccosine = new Arccosine();


    @ParameterizedTest
    @ValueSource(doubles = {-1,1,0.3444213})
    public void checkCalculate(double x) {
        Assertions.assertEquals(
                arccosine.calculateWithMath(x),
                arccosine.calculate(x),0.1
        );
    }

    @ParameterizedTest
    @ValueSource(doubles = {-123,123, Double.POSITIVE_INFINITY,Double.NEGATIVE_INFINITY})
    public void checkIfOutOfBorders(double x)
    {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> arccosine.calculate(x),
                "Argument must be a number"
        );
    }

    @Test
    public void checkIfNan()
    {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> arccosine.calculate(Double.NaN),
                "Argument must be in [-1;1] section"
        );
    }




}