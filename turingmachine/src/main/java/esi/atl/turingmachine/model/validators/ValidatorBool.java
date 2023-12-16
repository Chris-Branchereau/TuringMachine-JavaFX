package esi.atl.turingmachine.model.validators;

/**
 * main method for validators
 */
public abstract class ValidatorBool implements Validator{
    private boolean isValid;
    private boolean isTested = false;
    protected int number;
    public ValidatorBool(int number){
        this.number = number;
    }

    public void setValid(boolean isValid){
        this.isValid = isValid;
        isTested = true;
    }
    public boolean isValid(){
        return isValid;
    }
    public boolean isTested(){
        return isTested;
    }
    public void setTested(boolean isTested){
        this.isTested = isTested;
    }
    public int getNumber(){
        return number;
    }
}
