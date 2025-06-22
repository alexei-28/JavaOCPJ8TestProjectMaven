package com.gmail.alexei28.ocpj8.outerclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OuterClass {
    static final Logger logger = LoggerFactory.getLogger(OuterClass.class);

    // create main method
    public static void main(String[] args) {
        logger.info("Java version: {}, Java vendor: {}", System.getProperty("java.version")
                , System.getProperty("java.vendor"));

        abstract class InnerClassA {
            public abstract int calc(int x);
        }
        //someMethod("test"); // compile error: Cannot resolve method 'someMethod' in 'OuterClas

        // anonymous inner class
        InnerClassA anonymousInnerClass = new InnerClassA() {
            @Override
            public int calc(int x) {
                return x * x;
            }

            public void someMethod() {
                logger.info("Hello from anonymous inner class {}", calc(3));
            }
        };
        logger.info("anonymousInnerClass: {}",anonymousInnerClass.calc(2));
    }
}
