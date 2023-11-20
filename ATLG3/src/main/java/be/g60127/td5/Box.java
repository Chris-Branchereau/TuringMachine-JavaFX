package be.g60127.td5;

public class Box<T> {
    T element;

    public Box(T element) {
        this.element = element;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        return "[" + element + "]";
    }

    public static void main(String[] args) {
        Box<Integer> box = new Box<Integer>(42);
        Integer value = box.getElement();
        System.out.println(box);
        System.out.println(value);
        box.setElement(43);
        System.out.println(box);
        Box<Object> box1 = new Box<>(42);
        //box.setElement(new Double(43));
    }
}
