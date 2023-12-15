package esi.atl.turingmachine.model;

import esi.atl.turingmachine.model.validators.Validator;
import esi.atl.turingmachine.model.validators.Validators;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Round> rounds = new ArrayList<Round>();
    private Round currentRound;
    private Code secretCode;
    private int score;
    private List<Validator> validators = new ArrayList<Validator>();

    public Game(Code secretCode, int... validatorNB) {
        this.secretCode = secretCode;
        this.currentRound = new Round();
        rounds.add(currentRound);
        this.score = 0;
        for (int i = 0; i < validatorNB.length; i++) {
            this.validators.add(Validators.getValidator(validatorNB[i]));
        }
    }

    public void selectValidator(int number) {
        if (validators.get(number).isTested()) throw new TuringException("You have already tested this validators.");
        if (currentRound.validatorsSize() >= 3) throw new TuringException("You can only test 3 validators per round.");
        currentRound.useValidator(validators.get(number));
        validators.get(number).setValid(validators.get(number).validate(secretCode, getCode()));
    }

    public void setCode(Code code) {
        currentRound.setCode(code);
    }

    public void nextRound() {
        rounds.add(currentRound);
        currentRound = new Round();
        score = rounds.size();
        for (Validator validator : validators ){
            validator.setTested(false);
        }
    }
    public List<Validator> getValidators(){
        return validators;
    }
    public void removeLastValidator(){
        currentRound.removeValidator();
    }
    public Code getCode() {
        return currentRound.getCode();
    }

    public int getScore() {
        return score;
    }
}
