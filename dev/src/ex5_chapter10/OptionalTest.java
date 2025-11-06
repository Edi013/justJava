package ex5_chapter10;

import java.util.Optional;
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


    private static void howToNotManipulateAnOptional(Optional<Integer> optional) {
        if (optional.isPresent()) {  // outer if
            var num = optional.get();
            var string = "" + num;
            if (string.length() == 3) // inner if
                System.out.println(string);
        }
    }
    private static void howToManipulateAnOptional(Optional<Integer> optional) {
        optional.map(n -> "" + n)            // part 1
                .filter(s -> s.length() == 3)     // part 2
                .ifPresent(System.out::println);  // part 3
    }
}
