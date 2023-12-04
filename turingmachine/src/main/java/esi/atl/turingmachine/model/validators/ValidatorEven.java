package esi.atl.turingmachine.model.validators;

public class ValidatorEven implements Validator{
    @Override
    public boolean check(int number, int code, int code1) {
        int first = Integer.toString(code).charAt(0);
        int second = Integer.toString(code).charAt(1);
        int third = Integer.toString(code).charAt(2);

        int first1 = Integer.toString(code1).charAt(0);
        int second1 = Integer.toString(code1).charAt(1);
        int third1 = Integer.toString(code1).charAt(2);
        switch (number){
            default:
            case 5 : {
                return (first%2==0) == (first1%2==0);
            }
            case 6 : {
                return (second%2==0) == (second1%2==0);
            }
            case 7: {
                return (third%2==0) == (third1%2==0);
            }


        }
    }

}
