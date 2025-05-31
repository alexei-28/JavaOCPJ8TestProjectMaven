package com.gmail.alexei28.ocpj8.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Streams are lazily evaluated
public class StreamTest {
    private static final Logger logger = LoggerFactory.getLogger(StreamTest.class);

    public static void main(String[] args) {
        logger.info("Java version: {}, Java vendor: {}", System.getProperty("java.version")
                , System.getProperty("java.vendor"));

        //methodGroupByList();
        //methodGroupBySet();
        //methodPartitioningBy();
       // methodMapCounting();
        methodMapping();
    }

    private static void methodMapping() {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, Optional<Character>> map = ohMy.collect(
                Collectors.groupingBy(String::length, Collectors.mapping((String s) -> s.charAt(0), Collectors.minBy(Comparator.naturalOrder()))));
        logger.debug(map.toString()); //  {5=Optional[b], 6=Optional[t]}
    }

    private static void methodMapCounting() {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, Long> map = ohMy.collect(Collectors.groupingBy((it -> it.length()), Collectors.counting()));
        logger.debug(map.toString()); // {5=2, 6=1}
    }

    private static void methodPartitioningBy() {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Map<Boolean, Set<String>> mapGroupingBy = ohMy.collect(Collectors.partitioningBy(it -> it.length() <= 5, Collectors.toSet()));
        logger.debug(mapGroupingBy.toString()); //  {false=[tigers], true=[lions, bears]}
    }

    private static void methodGroupBySet() {
        logger.debug("methodGroupBySet");
        Stream<String> animals = Stream.of("lions", "tigers", "bears");
        Map<Integer, Set<String>> map = animals.collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        logger.debug("mapy = {}", map);
    }

    private static void methodGroupByList() {
        logger.debug("methodGroupByList");
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map = ohMy.collect(Collectors.groupingBy(String::length));
        logger.debug("map = {}", map);
    }

    public static void method() {
        List<String> cats = new ArrayList<>();
        cats.add("Annie");
        cats.add("Ripley");
        Stream<String> stream = cats.stream(); // here stream isn’t actually created, because it lazily evaluated
        cats.add("KC");
        logger.info("count = {}", stream.count()); // 3
    }

    /*-
        You are given an Optional<Integer> and asked to print the value, but only if it is a three-digit number.
    */
    private static void threeDigit(Optional<Integer> optional) {
        optional.map(n -> "" + n)
                .filter(s -> s.length() == 3)
                .ifPresent(System.out::println);
    }

    private static void method2() {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        String result = ohMy.collect(Collectors.joining(", "));
        logger.info(result); // lions, tigers, bears
    }

    private static void method3() {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        Double result = ohMy.collect(Collectors.averagingInt(String::length));
        logger.info("result = {}", result); // 5.333333333333333
    }

    /*-
        The peek() method is our final intermediate operation. It is useful for debugging because it
        allows us to perform a stream operation without actually changing the stream.
     */
    private static void methodPeek() {
        logger.debug("methodPeek");
        Stream ints = Stream.of("A", "B", "C", "D");
        ints.peek(System.out::println).skip(2).count();
    }

    private static void methodIdentity() {
        logger.debug("methodIdentity");
        Function function = Function.identity();
        System.out.println(function.apply("Hello")); // Hello
    }

    private static void method4() {
        logger.debug("method4");
        Function<String, Double> function = (String it) -> Double.parseDouble(it);
        Function<String, Double> function1 = function.andThen((Double s) -> s * 2);
        System.out.println(function1.apply("9")); // 18.0
    }
}
