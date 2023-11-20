package be.g60127.td5;

public class Pair<T extends Comparable<T>> {
    private final T first;
    private final T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public boolean ordered() {
        return first.compareTo(second) < 0;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public static void main(String[] args) {
        Pair<Integer> pair = new Pair<>(32, 42);
        //Pair<Number> pair = new Pair<>(new Integer(32), new
        //        Integer(42));
        System.out.println("la paire: " + pair
                + (pair.ordered() ? " est " : " n’est pas") + " ordonnée");
    }
}

