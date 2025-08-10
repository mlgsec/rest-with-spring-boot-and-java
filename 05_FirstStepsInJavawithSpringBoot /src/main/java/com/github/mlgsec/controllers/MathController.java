package com.github.mlgsec.controllers;

import com.github.mlgsec.exception.UnsupportedMathOperationException;
import com.github.mlgsec.math.SimpleMath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.github.mlgsec.request.converters.NumberConverter.convertToDouble;
import static com.github.mlgsec.request.converters.NumberConverter.isNumeric;

@RestController
@RequestMapping("/math")
public class MathController {

    SimpleMath math = new SimpleMath();

    // http://localhost:8080/math/sum/3/5
    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws UnsupportedMathOperationException {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return math.sum(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    // http://localhost:8080/math/subtraction/3/5
    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws UnsupportedMathOperationException {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return math.subtraction(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    // http://localhost:8080/math/subtraction/3/5
    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ) throws UnsupportedMathOperationException {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return math.multiplication(convertToDouble(numberOne), convertToDouble(numberTwo));
    }

    // http://localhost:8080/math/division/3/5
    @GetMapping("/division/{strNumberOne}/{strNumberTwo}")
    public Double division(
            @PathVariable("strNumberOne") String strNumberOne,
            @PathVariable("strNumberTwo") String strNumberTwo
    ) throws UnsupportedMathOperationException {
        if (!isNumeric(strNumberOne) || !isNumeric(strNumberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        Double numberOne = convertToDouble(strNumberOne);
        Double numberTwo = convertToDouble(strNumberTwo);

        if (numberTwo == 0) {
            throw new UnsupportedMathOperationException("Division by zero is not allowed.");
        }

        return math.division(numberOne, numberTwo);
    }


    // http://localhost:8080/math/mean/3,3,6,8,9 ...
    @GetMapping("/mean/{numbers}")
    public Double mean(@PathVariable String numbers) throws Exception {
        String[] numberArray = numbers.split(",");
        return math.mean(numberArray);
    }

    // http://localhost:8080/math/squareRoot/81
    @GetMapping("/squareroot/{number}")
    public Double squareRoot(@PathVariable String number) throws Exception {
        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        }
        double value = convertToDouble(number);
        return math.sqrt(value);
    }

}
