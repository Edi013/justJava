package StreamsPractice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsPractice {

    public int sumSquareOfEvenNumbers(List<Integer> nums) {
        Integer result = nums.stream()
                .filter(num -> num % 2 == 0)
                .map(num -> num * num)
                .reduce(0, Integer::sum);
        return result;
    }

    public List<Integer> sortedUnique(List<Integer> nums) {
        List<Integer> result = nums
                .stream()
                .distinct()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
        return result;
    }

    public String longestString(List<String> words) {
        if (words.isEmpty()) {
            return "";
        }
        return words.stream()
                .max((x,y) -> x.length() - y.length())
                .get();
    }

    public int totalCharacters(List<String> words) {
        return words.stream()
                .mapToInt(String::length)
                .reduce(0, (x, y) -> x + y);
                //.sum()
                //.reduce(0, Integer::sum);
    }

    public List<Integer> flatten(List<List<Integer>> nested) {
        return nested.stream()
                .flatMap(Collection::stream)
                .toList();
    }

    public Map<Character, List<String>> groupByFirstLetter(List<String> words) {
        return words.stream()
                .filter(x -> !x.isEmpty())
                .collect(Collectors.groupingBy((x)-> x.charAt(0)));
    }

    public Map<Boolean, List<Integer>> partitionEvenOdd(List<Integer> integers) {
        return integers.stream()
                .collect(Collectors.partitioningBy((x)-> x % 2 == 0));
    }

    public double averageOfList(List<Integer> integers) {
//        return integers.stream()
//                .mapToInt(Integer::intValue)
//                .average()
//                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
        return integers.stream()
                .mapToDouble(Integer::doubleValue)
                .sum() / (integers.isEmpty() ? 1 : integers.size());


    }

    public List<Integer> topNDescending(List<Integer> nums, int i) {
        return nums.stream()
                .sorted((x,y)-> y-x)
                .limit(i)
                .collect(Collectors.toList());
    }

    public Map<String, Long> wordFrequency(List<String> words) {
        var result =  words.stream()
                .filter(x -> !x.isEmpty())
                .collect(Collectors.groupingBy(
                        (x)-> String.valueOf(x.charAt(0)),
                        Collectors.counting()
                        ));
        return result;
    }
}
