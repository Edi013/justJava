package week_2_thursday_meeting;

public class Test3 implements Test, Test2{
    @Override
    public Integer test() {
        return 0;
    }

    @Override
    public void run() {
        //Test.super.run();
        //Test2.super.run();
        //super.run();
    }
    public static int juggle(boolean b, boolean... b2) {
        return b2.length;
    }

    public static void main(String[] args){
        System.out.println(juggle(true, new boolean[2]));
    }
}
