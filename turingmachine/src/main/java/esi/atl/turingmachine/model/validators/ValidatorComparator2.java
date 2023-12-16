package esi.atl.turingmachine.model.validators;

import esi.atl.turingmachine.model.Code;
import esi.atl.turingmachine.model.TuringException;

public class ValidatorComparator2 extends ValidatorBool {

    public ValidatorComparator2(int number) {
        super(number);
    }
    /**
     * Validates the comparison of two 2 codes
     *
     * @param secretCode The Code instance containing the secret values.
     * @param testCode   The Code instance containing the values to be tested.
     * @return true if the comparison is successful, false otherwise.
     * @throws TuringException If the validator number is invalid.
     */
    @Override
    public boolean validate(Code secretCode, Code testCode) {
        switch (number) {
            case 11: {
                return compare(secretCode.getIntPos(0), testCode.getIntPos(0), secretCode.getIntPos(1), testCode.getIntPos(1));
            }
            case 12: {
                return compare(secretCode.getIntPos(0), testCode.getIntPos(0), secretCode.getIntPos(2), testCode.getIntPos(2));
            }
            case 13: {
                return compare(secretCode.getIntPos(1), testCode.getIntPos(1), secretCode.getIntPos(2), testCode.getIntPos(2));
            }
            default: {
                throw new TuringException("Invalid Number Validator" + number);
            }
        }
    }
    /**
     * Compares two integers based on two specified comparators.
     *
     * @param a           The first integer.
     * @param b           The second integer.
     * @param comparatorA The comparator value for the first comparison.
     * @param comparatorB The comparator value for the second comparison.
     * @return true if both comparisons are successful, false otherwise.
     */

    private boolean compare(int a, int b, int comparatorA, int comparatorB) {
        return ((a == comparatorA) == (b == comparatorB))
                && ((a > comparatorA) == (b > comparatorB))
                && ((a < comparatorA) == (b < comparatorB));
    }
}
