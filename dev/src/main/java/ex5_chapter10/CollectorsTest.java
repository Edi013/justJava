package main.java.ex5_chapter10;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.*;

public class CollectorsTest {
    public void main(){
        test11_flatMap();
    }

    private void test1(){
        var ohMy = Stream.of("lions", "tigers", "bears");
        Double result = ohMy.collect(Collectors.averagingInt(String::length));
        System.out.println(result); // 5.333333333333333
    }

    private void test2(){
        var ohMy = Stream.of("lions", "tigers", "bears");
        TreeSet<String> result = ohMy
                .filter(s -> s.startsWith("t"))
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(result); // [tigers]
    }
    private void test3_mutable_immutable(){
        Stream<String> ohMy1 = Stream.of("lions", "tigers", "bears");
        List<String> mutableList = ohMy1.collect(Collectors.toList());

        Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears");
        List<String> immutableList = ohMy2.toList();

        mutableList.add("zebras");;
        immutableList.add("zebras");;
    }

    private void test4_groupingBy(){
        var ohMy1 = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map0 = ohMy1.collect(
                Collectors.groupingBy(String::length));
        System.out.println(map0);    // {5=[lions, bears], 6=[tigers]}

        var ohMy2 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Set<String>> map1 = ohMy2.collect(
                Collectors.groupingBy(
                        String::length,
                        Collectors.toSet()));
        System.out.println(map1);    // {5=[lions, bears], 6=[tigers]}

        var ohMy3 = Stream.of("lions", "tigers", "bears");
        TreeMap<Integer, Set<String>> map2 = ohMy3.collect(
                Collectors.groupingBy(
                        String::length,
                        TreeMap::new,
                        Collectors.toSet()));
        System.out.println(map2); // {5=[lions, bears], 6=[tigers]}

        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, Long> map = ohMy.collect(
                Collectors.groupingBy(
                        String::length,
                        Collectors.counting()));
        System.out.println(map);    // {5=2, 6=1}
    }

    private void test5_partitionBy(){
        //downstream collector
        var ohMy = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map = ohMy.collect(
                Collectors.partitioningBy(s -> s.length() <= 5));
        System.out.println(map);    // {false=[tigers], true=[lions, bears]}

        var ohMy2 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, Set<String>> map2 = ohMy2.collect(
                Collectors.partitioningBy(
                        s -> s.length() <= 7,
                        Collectors.toSet()));
        System.out.println(map2);    // {false=[], true=[lions, tigers, bears]}
    }

    private void test6_mapping(){
        var ohMy4 = Stream.of("lions", "tigers", "bears");
        Map<Integer, Optional<Character>> map4 = ohMy4.collect(
                Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(
                                s -> s.charAt(0),
                                Collectors.minBy((a, b) -> a - b))));
        System.out.println(map4);    // {5=Optional[b], 6=Optional[t]}
    }

    private void test7_collectAndThen(){
        var ohMy = Stream.of("lions", "tigers", "bears");

        Map<Integer, Character> map = ohMy.collect(
                Collectors.groupingBy(
                        String::length,
                        Collectors.collectingAndThen(
                                Collectors.mapping(
                                        s -> s.charAt(0),
                                        Collectors.minBy(Character::compare)
                                ),
                                Optional::get // unwrap Optional safely
                        )
                )
        );

        System.out.println(map); // {5=b, 6=t}

        // Simplify it using :
        var ohMy2 = Stream.of("lions", "tigers", "bears");

        // unwrap Optional safely
        Map<Integer, Character> map2 = ohMy2.collect(
                Collectors.toMap(String::length,
                        s -> s.charAt(0),
                        BinaryOperator.minBy(Character::compare))
        );

        System.out.println(map2); // {5=b, 6=t}
    }

    private void test8_teeingCollectors(){
        record Separations(String spaceSeparated, String commaSeparated) {}
        var list = List.of("x", "y", "z");
        Separations result = list.stream()
                .collect(Collectors.teeing(
                        Collectors.joining(" "),
                        Collectors.joining(","),
                        Separations::new)); //(s, c) -> new Separations(s, c)));
        System.out.println(result); //Separations[spaceSeparated=x y z, commaSeparated=x,y,z]
    }

    private void test9_spliterator(){
        var stream = List.of("bird-", "bunny-", "cat-", "dog-", "fish-", "lamb-", "mouse-");
         Spliterator<String> originalBagOfFood = stream.spliterator();
         Spliterator<String> emmasBag = originalBagOfFood.trySplit();
         emmasBag.forEachRemaining(System.out::print);  // bird-bunny-cat-

         Spliterator<String> jillsBag = originalBagOfFood.trySplit();
         jillsBag.tryAdvance(System.out::print);        // dog-
         jillsBag.forEachRemaining(System.out::print);  // fish-

        originalBagOfFood.forEachRemaining(System.out::print); // lamb-mouse-
    }

    // Conversie intre streamuri
    // map() conserva tipul curent
    // mapToObj() din orice trece la tipul Stream
    // mapToDouble() din orice trece la tipul DoubleStream
    // mapToInt() din orice trece la IntStream
    // mapToLong() din orice trece la LongStream
    // orice fiind multimea {Stream, Double Stream, IntStream, LongStream} excluzand tipul curent
    private void test10_conversionBetweenStreamTypes(){
        var integerList = new ArrayList<Integer>();
        IntStream ints = integerList.stream()
                .flatMapToInt(x -> IntStream.of(x));
        DoubleStream doubles = integerList.stream()
                .flatMapToDouble(x -> DoubleStream.of(x));
        LongStream longs = integerList.stream()
                .flatMapToLong(x -> LongStream.of(x));
    }

    private void test11_flatMap(){
        List<Integer> x1 = List.of(1, 2, 3);
        List<Integer> x2 = List.of(4, 5, 6);
        List<Integer> x3 = List.of();
        Stream.of(x1, x2, x3)
                .flatMap(x -> x.stream())
                .forEach(System.out::print);
    }

}
