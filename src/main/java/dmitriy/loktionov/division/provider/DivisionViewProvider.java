package dmitriy.loktionov.division.provider;

import dmitriy.loktionov.division.domain.DivisionStep;

import java.util.List;

public interface DivisionViewProvider {
    String provideDivisionView(List<DivisionStep> steps, int dividend, int divider);
}
