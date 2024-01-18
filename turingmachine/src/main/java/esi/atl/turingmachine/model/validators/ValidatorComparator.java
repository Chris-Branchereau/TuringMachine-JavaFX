package esi.atl.turingmachine.model.validators;

import esi.atl.turingmachine.model.Code;
import esi.atl.turingmachine.model.TuringException;

public class ValidatorComparator extends ValidatorBool{

    public ValidatorComparator(int number){
        super(number);
    }

    /**
     * Validates the comparison of two codes;
     *
     * @param secretCode The Code instance containing the secret values.
     * @param testCode   The Code instance containing the values to be tested.
     * @return true if the comparison is successful, false otherwise.
     * @throws TuringException If the validator number is invalid.
     */
    @Override
    public boolean validate(Code secretCode, Code testCode) {
        switch (number){
            // @pbt don't use switch in validate but in constructor
            case 1 : {
                return compare(secretCode.getIntPos(0),
                        testCode.getIntPos(0), 1);
            }
            // @pbt long lines
            case 2 : {
                return compare(secretCode.getIntPos(0),
                        testCode.getIntPos(0),3);
            }
            case 3: {
                return compare(secretCode.getIntPos(1),testCode.getIntPos(1), 3);
            }
            case 4 : {
                return compare(secretCode.getIntPos(1),testCode.getIntPos(1), 4);
            }
            case 19 : {
                return compare(secretCode.getIntPos(0)+secretCode.getIntPos(1), testCode.getIntPos(0)+testCode.getIntPos(1),6);
            }
            default : {
                throw  new TuringException("Invalid Number Validator" + number);
            }
        }
    }
    /**
     * Compares two integers based on the specified comparator.
     *
     * @param a The first integer.
     * @param b The second integer.
     * @param comparator The comparator value for the comparison.
     * @return true if the comparison is successful, false else.
     */
    private boolean compare(int a, int b, int comparator){
        return (((a == comparator) == (b == comparator))
                && ((a >comparator) == (b>comparator))
                && ((a<comparator) == (b<comparator)));
    }
}
