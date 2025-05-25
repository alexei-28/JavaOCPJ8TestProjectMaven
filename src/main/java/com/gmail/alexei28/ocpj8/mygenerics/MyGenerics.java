package com.gmail.alexei28.ocpj8.mygenerics;

import com.gmail.alexei28.ocpj8.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class MyGenerics {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Java version: {}, Java vendor: {}", System.getProperty("java.version")
                , System.getProperty("java.vendor"));

        List<? extends Number> list = new ArrayList<>();
        //list.add(new Integer(10)); // compile error - method java.util.List.add(capture#1 of ? extends java.lang.Number) is not applicable
        //list.add(new Double(1.2));

        logger.debug(list.get(0) + "" + list.get(1));
    }
}
