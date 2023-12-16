package esi.atl.turingmachine.model.validators;

import esi.atl.turingmachine.model.Code;
import esi.atl.turingmachine.model.TuringException;

public class ValidatorCountEven extends ValidatorBool {



    public ValidatorCountEven(int number){
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

            case 16 : {
                return isMoreEven(secretCode) == isMoreEven(testCode);
            }
            case 17 : {
                return countEven(secretCode) == countEven(testCode);
            }
            case 18 : {
                return ((secretCode.getIntPos(0) + secretCode.getIntPos(1) + secretCode.getIntPos(2)) % 2 == 0)
                        == ((testCode.getIntPos(0) + testCode.getIntPos(1) + testCode.getIntPos(2)) % 2 == 0);
            }
            default : {
                throw new TuringException("Invalid Number Validator" + number);
            }
        }

    }

    private boolean isMoreEven(Code code) {
        return countEven(code) > counterOdd(code);
    }

    private int countEven(Code code) {
        int counter = 0;

        for (int i = 0; i < 3; i++) {
            if (code.getIntPos(i) % 2 == 0) counter++;
        }
        return counter;
    }

    private int counterOdd(Code code) {
        return 3 - countEven(code);
    }


}
