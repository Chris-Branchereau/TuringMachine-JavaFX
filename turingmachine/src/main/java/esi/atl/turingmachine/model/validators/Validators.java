package esi.atl.turingmachine.model.validators;

import esi.atl.turingmachine.model.Code;
import esi.atl.turingmachine.model.TuringException;

public abstract class Validators {


    public static Validator getValidator(int number) {
        switch (number) {
            case 1:
            case 2:
            case 3:
            case 4: {
                return new ValidatorComparator(number);
            }
            case 5:
            case 6:
            case 7: {
                return new ValidatorEven(number);
            }
            case 8:
            case 9:
            case 10: {
                return new ValidatorCount(number);
            }
            case 11:
            case 12:
            case 13: {
                return new ValidatorComparator2(number);
            }
            case 14:
            case 15: {
                return new ValidatorExtremum(number);
            }
            case 16:
            case 17:
            case 18: {
                return new ValidatorCountEven(number);
            }
            case 19: {
                return new ValidatorComparator(number);
            }
            case 20: {
                return new ValidatorCount(number);
            }
            case 21: {
                return new ValidatorTwin(number);
            }
            case 22: {
                return new ValidatorOrder(number);
            }
            default: {
                throw new TuringException("Invalid Validator Number: " + number);
            }
        }
    }


}
