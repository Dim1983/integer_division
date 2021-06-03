package dmitriy.loktionov.division.validator;

public class DivisionValidatorImpl implements DivisionValidator {

    @Override
    public void validation(int dividend, int divider) {
        if (dividend == 0) {
            throw new IllegalArgumentException("Division is zero");
        }
        if (dividend < 0) {
            throw new IllegalArgumentException(String.format("Dividend: %d less 0", dividend));
        }
        if (divider < 0) {
            throw new IllegalArgumentException(String.format("Divider: %d less 0", divider));
        }
    }
}
