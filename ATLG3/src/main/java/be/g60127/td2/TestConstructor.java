package be.g60127.td2;
class A {
    A() {
        super();
        System.out.println("constructor of A");
    }
}

class B extends A {
    B() {
        super();
        System.out.println("constructor of B");
    }
}

class C extends B {
    C() {
        super();
        System.out.println("constructor of C");
    }
}

public class TestConstructor {

    public static void main(String[] args) {
        new C();
    }
}
