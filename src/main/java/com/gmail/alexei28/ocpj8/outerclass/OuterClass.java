package com.gmail.alexei28.ocpj8.outerclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OuterClass {
    static final Logger logger = LoggerFactory.getLogger(OuterClass.class);

    // create main method
    public static void main(String[] args) {
        logger.info("Java version: {}, Java vendor: {}", System.getProperty("java.version")
                , System.getProperty("java.vendor"));

        abstract class A {
            public abstract int calc(int x);
        }

        // anonymous inner class
        A a = new A() {
            public int calc(int x) {
                return x * x;
            }

            public void print() {
                logger.debug("Hello from anonymous inner class");
            }
        };
        logger.info("result: {}",a.calc(2));
    }
}
