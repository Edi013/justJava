package main.java.ex_java_practice_Lambdas_Collections_Streams;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Section1 {

    public static void main(String[] args){
        section1_1();
        section1_2(List.of("Name1", "Name2", "Name3333", "Name444", "Name5555","Name6"));
        section1_3();
        section1_4();
    }

    public static void section1_1(){
        // 1.1
        List<Integer> numbers = IntStream.rangeClosed(1, 20)
                .boxed()
                .collect(Collectors.toList());

        Predicate<Integer> isEven = x -> x % 2 == 0;
        Predicate<Integer> greaterThan10 = x -> x > 10;

        List<Integer> resultWithAnd = numbers.stream()
                .filter(isEven.and(greaterThan10))
                .collect(Collectors.toList());
        List<Integer> resultWithOr = numbers.stream()
                .filter(isEven.or(greaterThan10))
                .collect(Collectors.toList());

        System.out.println("ResultWithAnd: " + resultWithAnd);
        System.out.println("ResultWithOr: " + resultWithOr);
    }

    public static void section1_2(List<String> names){
        Map<String, Integer> nameLengthMap = names.stream()
                .collect(Collectors.toMap(
                        name -> name, // Function.identity() is a fn that returns the input it is given
                        name -> name.length()
                ));
        nameLengthMap.forEach((name, length) -> System.out.println(name + " - " + length));
    }

    public static void section1_3(){
        Supplier<LocalDate> getCurrentDate = LocalDate::now; //() -> LocalDate.now();
        System.out.println("Current date: " + getCurrentDate.get());
        Consumer<String> printWelcomeMessage = (String name) -> System.out.println("Welcome " + name + " !");
        List.of("User1", "User2").forEach(printWelcomeMessage);
    }

    public static void section1_4(){
        List<String> names = Arrays.asList("Alice", "bob", "Charlie", "diana");

        names.forEach(name -> System.out.println(name));
        names.forEach(System.out::println);

        names.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        names.sort(String::compareToIgnoreCase);

        System.out.println("Sorted names:");
        names.forEach(name -> System.out.println(name));
    }
}
