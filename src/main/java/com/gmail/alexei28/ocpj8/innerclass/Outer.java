package com.gmail.alexei28.ocpj8.innerclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Outer {
    private static final Logger logger = LoggerFactory.getLogger(Outer.class);

    public static  void main(String[] args) {
        // Create an instance of the inner class
        Outer.Inner inner = new Outer().new Inner();
        //Inner inner = new Inner(); // compile error: non-static variable this cannot be referenced from a static context
        inner.y = 10;
        inner.display();
    }

    class Inner {
        private int y = 0;
        public void display() {
            logger.debug("Hello from the inner class, y = {}", y);
        }
    }
}
