package esi.atl.turingmachine.model;

import esi.atl.turingmachine.model.validators.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * defines a round
 */
public class Round {
    private Code currentCode;
    private List<Validator> validators = new ArrayList<Validator>();
    public Round(){

    }
    public void useValidator(Validator validator){
        validators.add(validator);

    }
    public void removeValidator(){
        validators.remove(validators.size()-1);
    }
    public int validatorsSize(){
        return validators.size();
    }

    public void setCode(Code code){
        currentCode = code;
    }
    public Code getCode(){
        return currentCode;
    }
}
