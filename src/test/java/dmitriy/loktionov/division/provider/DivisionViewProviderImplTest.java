package dmitriy.loktionov.division.provider;

import dmitriy.loktionov.division.domain.DivisionStep;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class DivisionViewProviderImplTest {

    DivisionViewProviderImpl divisionViewProviderTest = new DivisionViewProviderImpl();
    DivisionStep step1 = new DivisionStep(38, 36, 19);
    DivisionStep step2 = new DivisionStep(29, 28, 7);
    DivisionStep step3 = new DivisionStep(14, 12, 3);
    DivisionStep step4 = new DivisionStep(25, 24, 6);
    List<DivisionStep> stepsTest = Arrays.asList(step1, step2, step3, step4);

    @Test
    void provideDivisionViewTestShouldBeReturnStrings() {
        String actual = "_78945|4    \n" +
                " 4    |-----\n" +
                " -    |19736\n" +
                "_38 \n" +
                " 36\n" +
                " --\n" +
                " _29 \n" +
                "  28\n" +
                "  --\n" +
                "  _14 \n" +
                "   12\n" +
                "   --\n" +
                "   _25 \n" +
                "    24\n" +
                "    --\n" +
                "     1";
        String expected = divisionViewProviderTest.provideDivisionView(stepsTest, 78945, 4);

        assertThat(actual, is(expected));
    }

    @Test
    void provideDivisionViewTestShouldBeReturnStringIfFirstArgsNull() {
        List<DivisionStep> step = Arrays.asList(new DivisionStep(0, 0, 0));
        String result = divisionViewProviderTest.provideDivisionView(step, 0, 5);
        String expected = "_0|5    \n 5    |-----\n -    |0\n_0 \n 0\n --\n     0";

        assertThat(expected, is(result));
    }

    @Test
    void provideDivisionViewTestShouldBeReturnStringIfFirstArgsOne() {
        List<DivisionStep> step = Arrays.asList(new DivisionStep(1, 0, 0));
        String result = divisionViewProviderTest.provideDivisionView(step, 1, 5);
        String expected = "_1|5    \n 5    |-----\n -    |0\n_1 \n 0\n --\n     1";

        assertThat(expected, is(result));
    }

    @Test
    void provideDivisionViewTestShouldBeReturnStringIfNumberPositionIsOne() {
        List<DivisionStep> step = Arrays.asList(new DivisionStep(5, 5, 1));
        String result = divisionViewProviderTest.provideDivisionView(step, 5, 5);
        String expected = "_5|5    \n" +
                " 5    |-----\n" +
                " -    |1\n" +
                "_5 \n" +
                " 5\n" +
                " --\n" +
                "     0";

        assertThat(expected, is(result));
    }

    @Test
    void provideDivisionViewTestShouldBeReturnStringIfArgsHaveAnyNulls() {
        DivisionStep step1 = new DivisionStep(10, 10, 2);
        DivisionStep step2 = new DivisionStep(0, 0, 0);
        DivisionStep step3 = new DivisionStep(0, 0, 0);
        DivisionStep step4 = new DivisionStep(5, 5, 1);
        List<DivisionStep> step = Arrays.asList(step1, step2, step3, step4);

        String result = divisionViewProviderTest.provideDivisionView(step, 10005, 5);
        String expected = "_10005|5    \n" +
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

        assertThat(expected, is(result));
    }
}
