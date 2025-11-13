/*
package ex_custom;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Freestyle {
    public static void main(String[] args){
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

    public static void TestFoundation3(){
        Map<Integer, Integer> source = Map.of(3,3,4,4);

        // jdk 21 doesn't allow iteration over a map
        // for(var k : source){}
        // for(var k,v : source){}

        var testArr = new int[]{3, 4, 5};
        var length = testArr.length;

        var testArr2 = new ArrayList<Integer>();
        testArr2.size();

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> System.out.println("Hello"));    // execute() from Executor
        Future<Integer> future = executor.submit(() -> 42);     // submit() from ExecutorService
        executor.shutdown();

        try(ExecutorService executor2 = Executors.newVirtualThreadPerTaskExecutor()) {
            executor.submit(() -> {
                System.out.println("Running in a virtual thread");
            }).get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

    void crazyLoop(){
        var c = 0;
        JACK: while (c < 8){
            // JILL compiles or not
            JILL: System.out.println(c);
            if (c > 3) break JACK; else c++;
        }
    }

    public static <E extends CharSequence> List<? super E> doIt(List<E> nums){
        
    }

    public void Test1(){
        class Baap {     public int h = 4;     public int getH() {         System.out.println("Baap " + h);         return h;     } }  public class Beta extends Baap {     public int h = 44;     public int getH() {         System.out.println("Beta " + h);         return h;     }     public static void main(String[] args) {         Baap b = new Beta();         System.out.println(b.h + " " + b.getH());         Beta bb = (Beta) b;         System.out.println(bb.h + " " + bb.getH());     } }
    }
}
*/
