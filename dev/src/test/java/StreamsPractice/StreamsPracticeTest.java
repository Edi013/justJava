package StreamsPractice;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class StreamsPracticeTest {

    private final StreamsPractice service = new StreamsPractice();

    // 1. FILTER + MAP + SUM
    @Test
    void shouldSumSquareOfEvenNumbers() {
        List<Integer> nums = List.of(1, 2, 3, 4, 6);
        int result = service.sumSquareOfEvenNumbers(nums);
        assertEquals(4 + 16 + 36, result);
    }

    // 2. DISTINCT + SORTED
    @Test
    void shouldReturnSortedUniqueValues() {
        List<Integer> nums = List.of(5, 1, 2, 2, 3, 3, 10, 1);
        List<Integer> result = service.sortedUnique(nums);
        assertEquals(List.of(1, 2, 3, 5, 10), result);
    }

    // 3. MIN / MAX + OPTIONAL
    @Test
    void shouldReturnLongestString() {
        List<String> words = List.of("hi", "stream", "java", "world");
        String longest = service.longestString(words);
        assertEquals("stream", longest);
    }

    // 4. REDUCE (manual sum)
    @Test
    void shouldComputeTotalCharactersViaReduce() {
        List<String> words = List.of("a", "ab", "abc");
        int total = service.totalCharacters(words);
        assertEquals(1 + 2 + 3, total);
    }

    // 5. FLATMAP
    @Test
    void shouldFlattenListOfLists() {
        List<List<Integer>> nested = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5)
        );
        List<Integer> result = service.flatten(nested);
        assertEquals(List.of(1, 2, 3, 4, 5), result);
    }

    // 6. GROUPING BY FIRST LETTER
    @Test
    void shouldGroupByFirstLetter() {
        List<String> words = List.of("apple", "ant", "banana", "boat");
        Map<Character, List<String>> groups = service.groupByFirstLetter(words);

        assertEquals(List.of("apple", "ant"), groups.get('a'));
        assertEquals(List.of("banana", "boat"), groups.get('b'));
    }

    // 7. PARTITIONING (even / odd)
    @Test
    void shouldPartitionEvenAndOddNumbers() {
        Map<Boolean, List<Integer>> result = service.partitionEvenOdd(List.of(1, 2, 3, 4));

        assertEquals(List.of(2, 4), result.get(true));
        assertEquals(List.of(1, 3), result.get(false));
    }

    // 8. AVERAGE (primitive stream)
    @Test
    void shouldComputeAverage() {
        double avg = service.averageOfList(List.of(10, 20, 30));
        assertEquals(20.0, avg);
    }

    // 9. TOP N RESULTS (sorted + limit)
    @Test
    void shouldReturnTop3Descending() {
        List<Integer> nums = List.of(5, 2, 10, 8, 1);
        List<Integer> result = service.topNDescending(nums, 3);
        assertEquals(List.of(10, 8, 5), result);
    }

    // 10. WORD FREQUENCY (groupingBy + counting)
    @Test
    void shouldCountWordFrequency() {
        List<String> words = List.of("a", "b", "a", "c", "b", "a");

        Map<String, Long> freq = service.wordFrequency(words);

        assertEquals(3L, freq.get("a"));
        assertEquals(2L, freq.get("b"));
        assertEquals(1L, freq.get("c"));
    }
}
