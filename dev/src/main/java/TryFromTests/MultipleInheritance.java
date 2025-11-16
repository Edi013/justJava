package main.java.TryFromTests;

public class MultipleInheritance {
   /* public class A {}
    public class B extends  A {}
    public class C extends  A {}*/
    // public class D extends  B,C {}

   /* interface Z {}
    interface Y extends Z{
        void test();
    }
    interface W extends Z{
        void test();
    }
     static class ZZ implements Y, W{

        @Override
        public void   test() {
            System.out.println("tests");
        }

    }*/

    class Test1{}
    static class Test2{}
    public static void main(String[] args) {
        new MultipleInheritance.Test2();
    }
}
