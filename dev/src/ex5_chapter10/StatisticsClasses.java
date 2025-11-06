package ex5_chapter10;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class StatisticsClasses {
    public static  void main(){
        test1(IntStream.of(1,2,3));
    }
    private static void test1(IntStream ints) {
        IntSummaryStatistics stats = ints.summaryStatistics();
        if (stats.getCount() == 0) throw new RuntimeException();
        System.out.println("Max: " + stats.getMax());
        System.out.println("Min(imax): " + stats.getMin());
        System.out.println("Count: " + stats.getCount());
        System.out.println("Avg: " + stats.getAverage());
        System.out.println("String: " + stats.toString());
    }
}
