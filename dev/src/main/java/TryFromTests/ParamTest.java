package main.java.TryFromTests;

public class ParamTest {
    public static void printSum(int a, int b){
        System.out.println("In int "+(a+b));
    }

    public static void printSum(double... a){
        System.out.println("In double "+(a[0]+a[1]) );
    }

    public static void printSum(float a, float b){
        System.out.println("In float "+(a+b));
    }

    public static void printSum(int a, float b){
        System.out.println("In intfloat "+(a+b));
    }

    public static void main(String[] args) {
        printSum(1, 2.0);
        printSum(1, 2);
        printSum(1, 2.0f);
        printSum(1.0, 2.0f);
        printSum(1.0f, 2.0f);
    }
}