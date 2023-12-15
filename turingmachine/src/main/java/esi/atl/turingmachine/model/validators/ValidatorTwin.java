package esi.atl.turingmachine.model.validators;

import esi.atl.turingmachine.model.Code;
import esi.atl.turingmachine.model.TuringException;

public class ValidatorTwin extends ValidatorBool {


    public ValidatorTwin(int number) {
        super(number);

    }

    @Override
    public boolean validate(Code secretCode, Code testCode) {
        int counter = 0;
        int counter1 = 0;

        if (number == 21) {
            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 3; j++) {
                    if (secretCode.getIntPos(i) == secretCode.getIntPos(j))
                        counter++;
                    if (testCode.getIntPos(i) == testCode.getIntPos(j))
                        counter1++;
                }
            }
        } else {
            throw new TuringException("Invalid Number Validator" + number);
        }
        return (counter == 2) == (counter1 == 2);
    }

}
