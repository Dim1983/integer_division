package dmitriy.loktionov.division.provider;

import dmitriy.loktionov.division.domain.DivisionStep;
import dmitriy.loktionov.division.provider.DivisionMathProviderImpl;
import org.hamcrest.collection.IsEmptyCollection;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;

class DivisionMathProviderImplTest {
    DivisionMathProviderImpl divisionMathProviderTest = new DivisionMathProviderImpl();



    @Test
    void provideMathCalculationTestShouldBeReturnTrueListArguments() {
        DivisionStep step1 = new DivisionStep(38, 36, 19);
        DivisionStep step2 = new DivisionStep(29, 28, 7);
        DivisionStep step3 = new DivisionStep(14, 12, 3);
        DivisionStep step4 = new DivisionStep(25, 24, 6);

        List<DivisionStep> expected = Arrays.asList(step1,step2, step3, step4);
        List<DivisionStep> result = divisionMathProviderTest.provideMathCalculation(78945, 4);

        assertThat(expected, is(result));
    }

    @Test
    void provideMathCalculationTestShouldBeReturnObjectWithEmptyFields () {
        DivisionStep step1 = new DivisionStep(0,0,0);
        List<DivisionStep> result = divisionMathProviderTest.provideMathCalculation(0, 5);
        List<DivisionStep> expected = Arrays.asList(step1);

        assertThat(expected, is(result));
    }

    @Test
    void provideMathCalculationTestShouldBeReturnObjectWithOneFieldsWhenHaveNumbers () {
        DivisionStep step1 = new DivisionStep(1,0,0);
        List<DivisionStep> result = divisionMathProviderTest.provideMathCalculation(1, 5);
        List<DivisionStep> expected = Arrays.asList(step1);

        assertThat(expected, is(result));
    }

    @Test
    void provideMathCalculationTestShouldBeReturnObjectWithAnyFieldHaveNumbers () {
        DivisionStep step1 = new DivisionStep(5,5,1);
        List<DivisionStep> result = divisionMathProviderTest.provideMathCalculation(5, 5);
        List<DivisionStep> expected = Arrays.asList(step1);

        assertThat(expected, is(result));
    }

    @Test
    void provideMathCalculationTestShouldBeReturnNotNull() {
        List<DivisionStep> result = divisionMathProviderTest.provideMathCalculation(78945, 4);

        assertThat(result, not(IsEmptyCollection.empty()));
    }

    @Test
    void provideMathCalculationTestShouldBeReturnNotEmptyElements() {
        List<DivisionStep> result = divisionMathProviderTest.provideMathCalculation(78945, 4);

        assertThat(result, hasItems(notNullValue()));
    }
}
