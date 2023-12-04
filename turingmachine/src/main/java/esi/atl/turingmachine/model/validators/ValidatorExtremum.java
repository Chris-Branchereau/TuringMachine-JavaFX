package esi.atl.turingmachine.model.validators;

public class ValidatorExtremum implements Validator{
    @Override
    public boolean check(int number, int code, int code1) {
        int first = Integer.toString(code).charAt(0);
        int second = Integer.toString(code).charAt(1);
        int third = Integer.toString(code).charAt(2);

        int first1 = Integer.toString(code1).charAt(0);
        int second1 = Integer.toString(code1).charAt(1);
        int third1 = Integer.toString(code1).charAt(2);
        switch (number){

            case 1 -> {

            }



        }
    }
    private int extremum(){
        for (int i = 0; i <3; i++){

        }
    }
}
