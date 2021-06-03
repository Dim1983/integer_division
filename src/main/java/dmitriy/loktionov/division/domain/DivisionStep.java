package dmitriy.loktionov.division.domain;

import java.util.Objects;

public class DivisionStep {
    private final int firstNumber;
    private final int secondNumber;
    private final int resultCount;

    public DivisionStep(int firstNumber, int secondNumber, int resultCount) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.resultCount = resultCount;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getSecondNumber() {
        return secondNumber;
    }

    public int getResultCount() {
        return resultCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DivisionStep that = (DivisionStep) o;
        return firstNumber == that.firstNumber &&
                secondNumber == that.secondNumber &&
                resultCount == that.resultCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstNumber, secondNumber, resultCount);
    }

    @Override
    public String toString() {
        return "DivisionStep{" +
                "firstNumber=" + firstNumber +
                ", secondNumber=" + secondNumber +
                ", resultCount=" + resultCount +
                '}';
    }
}
