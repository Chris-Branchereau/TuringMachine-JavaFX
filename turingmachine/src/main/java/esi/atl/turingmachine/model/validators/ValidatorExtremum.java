package esi.atl.turingmachine.model.validators;

import esi.atl.turingmachine.model.Code;
import esi.atl.turingmachine.model.TuringException;

public class ValidatorExtremum extends ValidatorBool{


    public ValidatorExtremum(int number) {
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

        switch (number){
            case 14 : {
                return min(secretCode) == min(testCode);
            }
            case 15 : {
                return max(secretCode) == max(testCode);
            }
            default : {
                throw new TuringException("Invalid Number Validator" + number);
            }
        }
    }
    private int min(Code code){
        int min = 6;
        int index = -1;
        for (int i = 0; i <3; i++){
            if (code.getIntPos(i)>=min){
                index = -1;
            } else {
               min = code.getIntPos(i);
               index = i;
            }
        }
        return index;
    }
    private int max(Code code){
        int max = 6;
        int index = -1;
        for (int i = 0; i <3; i++){
            if (code.getIntPos(i)<=max){
                index = -1;
            } else {
                max = code.getIntPos(i);
                index = i;
            }
        }
        return index;
    }
}
