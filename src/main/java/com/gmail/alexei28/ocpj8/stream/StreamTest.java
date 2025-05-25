package com.gmail.alexei28.ocpj8.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Streams are lazily evaluated
public class StreamTest {
    private static final Logger logger = LoggerFactory.getLogger(StreamTest.class);

    public static void main(String[] args) {
        logger.info("Java version: {}, Java vendor: {}", System.getProperty("java.version")
                , System.getProperty("java.vendor"));

        method3();
        // new AbstractCar(); // 'AbstractCar' is abstract; cannot be instantiated
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

}
