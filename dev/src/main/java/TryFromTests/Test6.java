package main.java.TryFromTests;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Test6 {
    public static void main(String[] args){
        // publicMethods this keyword are allowed in Enums !
        enum Card {
            HEART, CLUB, SPADE, DIAMOND;

            public boolean isRed(){
                return switch(this){
                    case HEART, DIAMOND -> true;
                    default -> false;
                };
            } 
        }
    }

   /* sealed interface Cacheable permits Value, Value2, Result{
        default void clear(){ System.out.println("clearing cache...");
        }
    }

    interface Value extends Cacheable{ }
    abstract interface Value2 extends Cacheable{ }
    non-sealed abstract class Result implements Cacheable{ }

    non-sealed interface Value extends Cacheable{ }
    non-sealed abstract class Result implements Cacheable{ }*/
}
