package esi.atl.turingmachine.model;

/**
 * Defines a Problem
 */
public class Problem {
    private int num;
    private int difficulty;
    private int luck;
    private Code code;
    private int[] validatorNB;

    public Problem(int num, int difficulty, int luck, Code code, int[] validatorNB){
        this.num = num;
        this.difficulty = difficulty;
        this.luck = luck;
        this.code = code;
        this.validatorNB = validatorNB;
    }

    public int getNum() {
        return num;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getLuck() {
        return luck;
    }

    public Code getCode() {
        return code;
    }

    public int[] getValidatorNB() {
        return validatorNB;
    }

}
