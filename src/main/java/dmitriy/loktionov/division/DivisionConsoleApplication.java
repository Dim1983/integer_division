package dmitriy.loktionov.division;

import dmitriy.loktionov.division.provider.DivisionMathProvider;
import dmitriy.loktionov.division.provider.DivisionMathProviderImpl;
import dmitriy.loktionov.division.validator.DivisionValidator;
import dmitriy.loktionov.division.validator.DivisionValidatorImpl;
import dmitriy.loktionov.division.provider.DivisionViewProvider;
import dmitriy.loktionov.division.provider.DivisionViewProviderImpl;

public class DivisionConsoleApplication {

    public static void main(String[] args) {
        DivisionValidator validator = new DivisionValidatorImpl();

        DivisionMathProvider mathProvider = new DivisionMathProviderImpl();

        DivisionViewProvider viewProvider = new DivisionViewProviderImpl();

        DivisionCalculator divisionCalculator = new DivisionCalculator(validator, mathProvider, viewProvider);

        System.out.println(divisionCalculator.calculate(78945, 4));
    }
}
