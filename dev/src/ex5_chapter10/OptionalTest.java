package ex5_chapter10;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class OptionalTest {
    public static void main(){
        max(IntStream.of(1));
        //max(IntStream.empty());
    }

    private static void max(IntStream ints) {
        OptionalInt optional = ints.max();
        optional.ifPresent(System.out::println);
        optional.orElseThrow(RuntimeException::new);
    }

}
