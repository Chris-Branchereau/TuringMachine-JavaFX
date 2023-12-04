package esi.atl.turingmachine.model.validators;

public class ValidatorCount implements Validator {
    @Override
    public boolean check(int number, int code, int code1) {
        int counter = 0;
        int counter1 = 0;
        switch (number) {
            default:
            case 8: {
                for (int i = 0; i < 3; i++){
                    if (Integer.toString(code).charAt(i) == 1) counter++;
                    if (Integer.toString(code1).charAt(i) == 1) counter1++;
                }
            }
            case 9: {
                for (int i = 0; i < 3; i++){
                    if (Integer.toString(code).charAt(i) == 3) counter++;
                    if (Integer.toString(code1).charAt(i) == 3) counter1++;
                }
            }
            case 10: {
                for (int i = 0; i < 3; i++){
                    if (Integer.toString(code).charAt(i) == 4) counter++;
                    if (Integer.toString(code1).charAt(i) == 4) counter1++;
                }
            }

        }
        return counter == counter1;
    }
}
