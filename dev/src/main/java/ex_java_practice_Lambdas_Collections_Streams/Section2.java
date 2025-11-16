package main.java.ex_java_practice_Lambdas_Collections_Streams;

import java.util.*;

public class Section2 {
    public static void main(String[] args ){
        Box<Box<Integer>> rawBoxInBoxBox = new Box<>();
        rawBoxInBoxBox.set(new Box<>(3));

        Box<Box<Integer>> rawBoxInBoxBox2 = new Box<>();
        rawBoxInBoxBox2.set(new Box<>(3));

        System.out.println("Sum of the 2+1: " + sum(List.of(1,2)));

        System.out.println("Sum of the 2 wrapees: " + sum(List.of(
                    rawBoxInBoxBox.get().get(),
                    rawBoxInBoxBox2.get().get()
        )));

        section2_4();
    }

    public static void section2_4(){
        Map<String, Double> catalog = Map.of("P1", 3.25, "P2", 1.11, "P3", 9.25);

        catalog.keySet().stream().sorted().forEach(System.out::println);

        Optional<Double> maxValue = catalog.values().stream().max(Double::compare); //return Double.compare(v1, v2);
        System.out.println(maxValue);
    }

    public static class Person implements Comparable<Person>, Comparator<Person>{
        private String name;
        private short age;

        public short getAge() {
            return age;
        }

        public String getName() {
            return name;
        }

        public void setAge(short age) {
            this.age = age;
        }

        public void setName(String name) {
            this.name = name;
        }


        @Override
        public int compare(Person person, Person other){
           int compareByName = person.getName().compareTo(other.getName());
           if(compareByName > 0)
               return +1;
           else if(compareByName < 0)
               return -1;

           return person.compareTo(other);
        }

        @Override
        public int compareTo(Person other) {
            if(this.age == other.age)
                    return 0;
            return this.age > other.age ? +1 : -1;
        }
    }

    public static double sum (List<Integer> numbers){
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        return sum;
    }

    public static class Box<T>{
        private T resource;

        Box(){}
        Box(T input){
            resource = input;
        }

        public void set(T input){
            resource = input;
        }

        public T get(){
            return resource;
        }

        // be carefull when using Method Reference, can't do it within a static context if the target method is non-static
        /*public static double sumGeneric (List<T extends Number> numbers){
            double sum = numbers.stream()
                    .mapToDouble(Double::doubleValue)
                    .sum();
            return sum;
        }*/
    }
}
