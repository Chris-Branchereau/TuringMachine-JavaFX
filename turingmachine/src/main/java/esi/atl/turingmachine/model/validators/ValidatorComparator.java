package esi.atl.turingmachine.model.validators;

import esi.atl.turingmachine.model.Code;
import esi.atl.turingmachine.model.TuringException;

public class ValidatorComparator extends ValidatorBool{



    public ValidatorComparator(int number){
        super(number);


    }
    @Override
    public boolean validate(Code secretCode, Code testCode) {

        switch (number){
            case 1 : {
                return compare(secretCode.getIntPos(0), testCode.getIntPos(0), 1);
            }
            case 2 : {
                return compare(secretCode.getIntPos(0),testCode.getIntPos(0),3);
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
    private boolean compare(int a, int b, int comparator){
        return (((a == comparator) == (b == comparator))
                && ((a >comparator) == (b>comparator))
                && ((a<comparator) == (b<comparator)));
    }
}
