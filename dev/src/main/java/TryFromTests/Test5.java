package main.java.TryFromTests;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.time.DayOfWeek.*;

public class Test5 {
    public static void test(){
        record Book(String title, String author) {}
        var books = new ArrayList<Book>(List.of(
                new Book("The Outsider", "Stephen King"),
                new Book("Becoming", "Michelle Obama" ),
                new Book("Uri", "India")));
        Stream bkStrm = books.stream();
        // count on Streams returns long !
        // if the stream is raw, you can still manual cast the objects and use their methods !
        long count = bkStrm.peek( x-> ((Book) x).title()).count();//2

        // to test them
        Period p;
        Duration d;

        // Why does Runnable takes a method that has the return type != void
        // Because it ignores the return value xD
        Runnable r = ()-> test();
    }

    public static void testPaths(String[] args){
        Path p1 = Paths.get("photos\\..\\beaches\\.\\calangute\\a.txt");
        Path p2 = p1.normalize();
        Path p3 = p1.relativize(p2);
        Path p4 = p2.relativize(p1);
        System.out.println(
                p1.getNameCount()+" "+p2.getNameCount()+" "+
                p3.getNameCount()+" "+p4.getNameCount());
    }

    public static void testEnum(String[] args){
        var day = LocalDate.now().with(FRIDAY).getDayOfWeek();
        switch(day){
            case MONDAY:
                TUESDAY:
                WEDNESDAY:
                THURSDAY:
                FRIDAY:
                System.out.println("working");
                case     SATURDAY:
                    SUNDAY:
                    System.out.println("off");
        }
    }

    public static void main(String[] args){
        var cin = new Comparable<Integer>(){
            public int compareTo(Integer i1){
                return "100".compareTo(""+i1);
            }
        };
        System.out.println(cin);
        System.out.println(cin.compareTo(3));
    }


        public int sum(int a, int b) { return a + b; }
    public int sum(long i1, long i2) { return (int) i1; }
    public int sum(int i1, long i2) { return (int) i2; }
}
