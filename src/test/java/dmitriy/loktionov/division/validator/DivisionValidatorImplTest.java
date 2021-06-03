package dmitriy.loktionov.division.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DivisionValidatorImplTest {

    private final DivisionValidatorImpl divisionValidatorTest = new DivisionValidatorImpl();

    @Test
    void validationShouldBeReturnNullPointerExceptionIfArgumentsNull() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> divisionValidatorTest.validation(0, 1));

        assertEquals("Division is zero", thrown.getMessage());
    }

    @Test
    void validationShouldBeReturnNullPointerExceptionIfFirstArgumentLessNull() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> divisionValidatorTest.validation(-78945, 1));

        assertEquals("Dividend: -78945 less 0", thrown.getMessage());
    }

    @Test
    void validationShouldBeReturnNullPointerExceptionIfSecondArgumentLessNull() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> divisionValidatorTest.validation(78945, -1));

        assertEquals("Divider: -1 less 0", thrown.getMessage());
    }
}
