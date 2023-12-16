package esi.atl.turingmachine.model;

/**
 * Defines a code of n digits
 */
public class Code {
    private int code;

    public Code(int code){
        this.code = code;
    }

    /**
     * get the digit in a chosen position
     * @param pos position chosen
     * @return the digit at the position "pos"
     */
    public int getIntPos(int pos){
        return Integer.parseInt(Integer.toString(code).charAt(pos)+"");
    }

    /**
     * get the code
     * @return the code
     */
    public int getCode(){
        return code;
    }
}
