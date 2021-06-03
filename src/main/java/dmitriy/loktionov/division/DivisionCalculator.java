package dmitriy.loktionov.division;

import dmitriy.loktionov.division.domain.DivisionStep;
import dmitriy.loktionov.division.provider.DivisionMathProvider;
import dmitriy.loktionov.division.validator.DivisionValidator;
import dmitriy.loktionov.division.provider.DivisionViewProvider;

import java.util.List;

public class DivisionCalculator {
    private final DivisionValidator validator;
    private final DivisionMathProvider mathProvider;
    private final DivisionViewProvider viewProvider;

    public DivisionCalculator(DivisionValidator validator, DivisionMathProvider mathProvider, DivisionViewProvider viewProvider) {
        this.validator = validator;
        this.mathProvider = mathProvider;
        this.viewProvider = viewProvider;
    }

    public String calculate(int dividend, int divisor) {
        validator.validation(dividend, divisor);
        List<DivisionStep> steps = mathProvider.provideMathCalculation(dividend, divisor);

        return viewProvider.provideDivisionView(steps, dividend, divisor);
    }
}
