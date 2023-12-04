package esi.atl.turingmachine.model.validators;

public class ValidatorComparator implements Validator{
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
            case 1 : {
                return compare(first,first1,1);
            }
            case 2 : {
                return compare(first,first1,3);
            }
            case 3: {
                return compare(second,second1, 3);
            }
            case 4 : {
                return compare(second,second1, 4);
            }
            case 11 : {
                return compare(first,first1, second,second1);
            }
            case 12 : {
                return compare(first,first1, third,third1);
            }
            case 13 : {
                return compare(second,second1, third,third1);
            }

        }
    }
    private boolean compare(int a, int b, int comparator){
        return ((a == comparator) == (b == comparator))
                && ((a >comparator) == (b>comparator))
                && ((a<comparator) == (b<comparator));
    }
    private boolean compare(int a, int b, int comparatorA, int comparatorB){
        return ((a == comparatorA) == (b == comparatorB))
                && ((a >comparatorA) == (b>comparatorB))
                && ((a<comparatorA) == (b<comparatorB));
    }
}
