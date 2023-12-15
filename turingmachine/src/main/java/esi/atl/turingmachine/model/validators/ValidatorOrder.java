package esi.atl.turingmachine.model.validators;

import esi.atl.turingmachine.model.Code;
import esi.atl.turingmachine.model.TuringException;

public class ValidatorOrder extends ValidatorBool {



    public ValidatorOrder(int number) {
        super(number);
    }

    @Override
    public boolean validate(Code secretCode, Code testCode) {

        switch (number) {
            case 21: {
                return order(secretCode) == order(testCode);
            }
            default: {
                throw new TuringException("Invalid Number Validator" + number);
            }
        }
    }

    public int order(Code code) {
        if (code.getIntPos(0) < code.getIntPos(1)) {
            if (code.getIntPos(1) < code.getIntPos(2)) {
                return 1;
            }
        } else if (code.getIntPos(0) > code.getIntPos(1)) {
            if (code.getIntPos(1) > code.getIntPos(2)) {
                return 2;
            }
        }
        return 0;


    }
}
