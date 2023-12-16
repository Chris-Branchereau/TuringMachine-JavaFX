package esi.atl.turingmachine.model.validators;

import esi.atl.turingmachine.model.Code;

/**
 * Defines all methods needed for validators
 */
public interface Validator {
    /**
     *
     * @param secretCode
     * @param testCode
     * @return
     */
    boolean validate(Code secretCode, Code testCode);
    void setValid(boolean isValid);
    boolean isValid();
    boolean isTested();
    void setTested(boolean isTested);
    int getNumber();

}
