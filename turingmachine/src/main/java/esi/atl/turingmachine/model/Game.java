package esi.atl.turingmachine.model;

import esi.atl.turingmachine.model.validators.Validator;
import esi.atl.turingmachine.model.validators.Validators;
import esi.atl.turingmachine.view.console.ViewConsole;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Round> rounds = new ArrayList<Round>();
    private Round currentRound;
    private int score;
    private final Code secretCode;
    private final List<Validator> validators = new ArrayList<Validator>();

    /**
     * Constructor called when a game start
     * @param secretCode = code to guess in this problem
     * @param validatorNB = list of validator for this problem 
     */
    public Game(Code secretCode, int... validatorNB) {
        this.secretCode = secretCode;
        this.currentRound = new Round();
        rounds.add(currentRound);
        this.score = 0;
        for (int i = 0; i < validatorNB.length; i++) {
            this.validators.add(Validators.getValidator(validatorNB[i]));
        }
    }

    /**
     * this select a validator for the current round
     * @param number = number of the validator selected
     */
    public void selectValidator(int number) {
        if (validators.get(number).isTested())
            throw new TuringException("You have already tested this validators.");
        if (currentRound.validatorsSize() >= 3)
            throw new TuringException("You can only test 3 validators per round.");
        currentRound.useValidator(validators.get(number));
        validators.get(number).setValid(validators.get(number).validate(secretCode, getCode()));
        score++;
    }

    /**
     * this set the code entered for the current round
     * @param code = code entered
     */
    public void setCode(Code code) {
        currentRound.setCode(code);
    }

    /***
     * pass to the next round
     */
    public void nextRound() {
        rounds.add(currentRound);
        currentRound = new Round();
        if (validators.size() > 0) {
            for (Validator validator : validators) {
                validator.setTested(false);
            }
        }
    }

    /**
     * get the total of rounds
     * @return total of rounds
     */
    public int getTotalRound() {
        return rounds.size();
    }

    /**
     * get the total of validators used
     * @return total of validators used
     */
    public int getTotalValidatorsUsed() {
        return score;
    }

    /**
     * get the list of validators for this game
     * @return list of validators 
     */
    public List<Validator> getValidators() {
        return validators;
    }

    /**
     * remove the last validator tested (called for undo command)
     */
    public void removeLastValidator() {
        currentRound.removeValidator();
    }

    /**
     * get the code setted for the current round
     * @return the code setted
     */
    public Code getCode() {
        return currentRound.getCode();
    }


}
