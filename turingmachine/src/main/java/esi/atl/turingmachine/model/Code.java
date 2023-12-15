package esi.atl.turingmachine.model;

public class Code {
    private int code;

    public Code(int code){
        this.code = code;
    }
    public int getIntPos(int pos){
        return Integer.parseInt(Integer.toString(code).charAt(pos)+"");
    }

    public int getCode(){
        return code;
    }
}
