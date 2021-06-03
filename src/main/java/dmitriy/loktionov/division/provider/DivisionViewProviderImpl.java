package dmitriy.loktionov.division.provider;

import dmitriy.loktionov.division.domain.DivisionStep;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DivisionViewProviderImpl implements DivisionViewProvider {

    private static final String EMPTY_STRING = "";
    private static final String SPACE_DELIMETR = " ";

    @Override
    public String provideDivisionView(List<DivisionStep> steps, int dividend, int divider) {
        return new StringBuilder()
                .append(String.format("_%d|%d    \n", dividend, divider))
                .append(String.format(" %d    |-----\n", divider))
                .append(String.format(" -    |%s\n", resultDivisionNumber(steps)))
                .append(String.format("%s", mapDivisionStepToLine(steps)))
                .append(String.format("     %s", getFinalStepDivision(steps))).toString();
    }

    private int getFinalStepDivision(List<DivisionStep> steps) {
        return steps.get((steps.size() - 1)).getFirstNumber()
                - steps.get((steps.size() - 1)).getSecondNumber();
    }

    private String mapDivisionStepToLine(List<DivisionStep> steps) {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> stepsDivisions = new ArrayList<>();
        for (DivisionStep step : steps) {
            int firstStepNumber = step.getFirstNumber();
            int secondStepNumber = step.getSecondNumber();
            stepsDivisions.add(String.format("%s_%s \n %s%s\n%s --\n", stringBuilder, firstStepNumber,
                    stringBuilder, secondStepNumber, stringBuilder));
            stringBuilder.append(SPACE_DELIMETR);
        }

        return stepsDivisions.stream().reduce(EMPTY_STRING, String::concat);
    }

    private String resultDivisionNumber(List<DivisionStep> steps) {
        return String.valueOf(steps.stream()
                .map(DivisionStep::getResultCount)
                .map(Objects::toString)
                .reduce(EMPTY_STRING, String::concat));
    }
}
