package dmitriy.loktionov.division;

import dmitriy.loktionov.division.domain.DivisionStep;
import dmitriy.loktionov.division.provider.DivisionMathProvider;
import dmitriy.loktionov.division.validator.DivisionValidator;
import dmitriy.loktionov.division.provider.DivisionViewProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DivisionCalculatorTest {

    @Mock
    private DivisionValidator validatorMock;

    @Mock
    private DivisionMathProvider mathProviderMock;

    @Mock
    private DivisionViewProvider viewProviderMock;

    @InjectMocks
    private DivisionCalculator divisionCalculator;

    @Test
    void calculateTestShouldBeThrowExceptionWhenArgumentNull() {
        doThrow(IllegalArgumentException.class).when(validatorMock).validation(0, 1);

        assertThrows(IllegalArgumentException.class, () -> divisionCalculator.calculate(0, 1));

        verify(validatorMock).validation(0, 1);
        verifyNoInteractions(mathProviderMock, viewProviderMock);
    }

    @Test
    void calculateTestShouldBeThrowExceptionWhenArgumentLessNull() {
        doThrow(IllegalArgumentException.class).when(validatorMock).validation(-78945, 1);

        assertThrows(IllegalArgumentException.class, () -> divisionCalculator.calculate(-78945, 1));
    }

    @Test
    void calculateTestShouldBeReturnString() {
        DivisionStep step1 = new DivisionStep(10, 10, 2);
        DivisionStep step2 = new DivisionStep(0, 0, 0);
        DivisionStep step3 = new DivisionStep(0, 0, 0);
        DivisionStep step4 = new DivisionStep(5, 5, 1);

        String result = "_10005|5    \n" +
                " 5    |-----\n" +
                " -    |2001\n" +
                "_10 \n" +
                " 10\n" +
                " --\n" +
                " _0 \n" +
                "  0\n" +
                "  --\n" +
                "  _0 \n" +
                "   0\n" +
                "   --\n" +
                "   _5 \n" +
                "    5\n" +
                "    --\n" +
                "     0";

        when(mathProviderMock.provideMathCalculation(10005, 5)).thenReturn(Arrays.asList(step1, step2, step3, step4));
        when(viewProviderMock.provideDivisionView(Arrays.asList(step1, step2, step3, step4), 10005, 5)).thenReturn(result);

        assertThat(divisionCalculator.calculate(10005, 5), is(result));

        verify(validatorMock).validation(10005, 5);
        verify(mathProviderMock).provideMathCalculation(10005, 5);
        verify(viewProviderMock).provideDivisionView(Arrays.asList(step1, step2, step3, step4),10005, 5);
    }
}
