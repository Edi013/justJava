package ex_custom;

public class Freestyle {
    public static void main(){

    }

    public static void TestFoundation1(){
        int x;
        boolean bool;
        if(true){} // no compile or runtime errors
        // if(x=3){} // compile error - numbers not allowed/evaluated as boolean
        if (bool = false) {}

    }

    public static void TestFoundation2(){
        int i = 1234567890;
        float f = i; //autoboxing

        // class MyString extends String{    MyString(){ super(); } } - doesn t compile to extend final class String
    }
}
