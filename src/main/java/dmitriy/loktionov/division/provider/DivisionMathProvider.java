package dmitriy.loktionov.division.provider;

import dmitriy.loktionov.division.domain.DivisionStep;

import java.util.List;

public interface DivisionMathProvider {
    List<DivisionStep> provideMathCalculation(int dividend, int divider);
}
