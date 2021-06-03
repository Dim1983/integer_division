package dmitriy.loktionov.division.provider;

import dmitriy.loktionov.division.domain.DivisionStep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DivisionMathProviderImpl implements DivisionMathProvider {
    private static final int DIVIDER = 10;

    @Override
    public List<DivisionStep> provideMathCalculation(int dividend, int divider) {
        List<DivisionStep> steps = new ArrayList<>();
        List<Integer> dividendConvertToNumbers = changeNumberInList(dividend);

        int bufferCount = dividendConvertToNumbers.get(0);
        for (int i = 1; i < dividendConvertToNumbers.size(); i++) {
            int firstNumberResultDivision = 0;
            if (bufferCount >= divider) {
                firstNumberResultDivision = getFirstNumberResultDivision(divider, bufferCount);
                bufferCount -= getBufferCount(divider, bufferCount);
            }
            int firstNumber = getCountFirstNumber(bufferCount) + dividendConvertToNumbers.get(i);
            int secondNumber = getCountSecondNumber(divider, firstNumber);
            int resultDivision = getCountResultDivision(divider, firstNumberResultDivision, firstNumber);
            bufferCount = firstNumber - secondNumber;
            steps.add(new DivisionStep(firstNumber, secondNumber, resultDivision));
        }

        return steps;
    }

    private int getCountResultDivision(int divider, int firstNumberResultDivision, int firstNumber) {
        return firstNumberResultDivision + (firstNumber / divider);
    }

    private int getCountSecondNumber(int divider, int firstNumber) {
        return (firstNumber / divider) * divider;
    }

    private int getCountFirstNumber(int bufferCount) {
        return bufferCount * DIVIDER;
    }

    private int getBufferCount(int divider, int bufferCount) {
        return divider * (bufferCount / divider);
    }

    private int getFirstNumberResultDivision(int divider, int bufferCount) {
        int firstNumberResultDivision;
        firstNumberResultDivision = (bufferCount / divider) * DIVIDER;

        return firstNumberResultDivision;
    }

    private List<Integer> changeNumberInList(int dividend) {
        List<Integer> numbers = new ArrayList<>();
        if (dividend < DIVIDER) {
            numbers.add(0);
            numbers.add(dividend);

            return numbers;
        }
        while (dividend >= 1) {
            numbers.add(dividend % DIVIDER);
            dividend /= DIVIDER;
        }

        Collections.reverse(numbers);

        return numbers;
    }
}
