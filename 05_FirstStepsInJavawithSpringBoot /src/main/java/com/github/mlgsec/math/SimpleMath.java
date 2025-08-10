package com.github.mlgsec.math;

import com.github.mlgsec.exception.UnsupportedMathOperationException;

import static com.github.mlgsec.request.converters.NumberConverter.convertToDouble;
import static com.github.mlgsec.request.converters.NumberConverter.isNumeric;

public class SimpleMath {

    public Double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }

    public Double subtraction(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }

    public Double multiplication(Double numberOne, Double numberTwo) {
        return numberOne * numberTwo;
    }

    public Double division(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }

    public Double mean(String[] numberArray) {
        if (numberArray == null || numberArray.length == 0) {
            throw new UnsupportedMathOperationException("No values provided to calculate the mean.");
        }

        double sum = 0;

        for (String num : numberArray) {
            if (!isNumeric(num)) {
                throw new UnsupportedMathOperationException(
                        "The value '" + num + "' is not a valid number. Please provide numeric values."
                );
            }
            sum += convertToDouble(num);
        }
        return division(sum, (double) numberArray.length);
    }

    public Double sqrt(Double number) {
        if (number < 0) {
            throw new UnsupportedMathOperationException("Cannot calculate square root of negative number.");
        }
        return Math.sqrt(number);
    }
}
