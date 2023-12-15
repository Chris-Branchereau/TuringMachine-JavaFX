package esi.atl.turingmachine.model.validators;

import esi.atl.turingmachine.model.Code;

public interface Validator {
    boolean validate(Code secretCode, Code testCode);
    void setValid(boolean isValid);
    boolean isValid();
    boolean isTested();
    void setTested(boolean isTested);
    int getNumber();

}
