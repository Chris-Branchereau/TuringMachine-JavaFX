package esi.atl.turingmachine.model.validators;

import esi.atl.turingmachine.model.Code;
import esi.atl.turingmachine.model.TuringException;

public class ValidatorEven extends ValidatorBool {



    public ValidatorEven(int number) {
        super(number);

    }

    @Override
    public boolean validate(Code secretCode, Code testCode) {
        switch (number) {

            case 5: {
                return (secretCode.getIntPos(0) % 2 == 0) == (testCode.getIntPos(0) % 2 == 0);
            }
            case 6: {
                return (secretCode.getIntPos(1) % 2 == 0) == (testCode.getIntPos(1) % 2 == 0);
            }
            case 7: {
                return (secretCode.getIntPos(2) % 2 == 0) == (testCode.getIntPos(2) % 2 == 0);
            }
            default: {
                throw new TuringException("Invalid Number Validator" + number);
            }
        }

    }
}
