package com.gmail.alexei28.ocpj8.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/*-
 That behave a little differently than the other concurrent examples that you have seen. These
  classes copy all of their elements to a new underlying structure anytime an element is
  added, modified, or removed from the collection. By a modifi ed element, we mean that the
  reference in the collection is changed. Modifying the actual contents of the collection will
  not cause a new structure to be allocated.
  Although the data is copied to a new underlying structure, our reference to the object
  does not change. This is particularly useful in multi-threaded environments that need
  to iterate the collection. *Any iterator established prior to a modification will not see the
  changes, but instead it will iterate over the original elements prior to the modification.

   When executed as part of a program, this code snippet outputs the following:
   4 3 52
   Size: 6

   Despite adding elements to the array while iterating over it, only those elements in the
   collection at the time the for() loop was created were accessed. Alternatively, if we had
   used a regular ArrayList object, a ConcurrentModificationException would have been
   thrown at runtime. With either class, though, we avoid entering an infinite loop in which
   elements are constantly added to the array as we iterate over them.
    The CopyOnWrite classes can use a lot of memory, since a new collection structure needs
   be allocated anytime the collection is modified. They are commonly used in multi-threaded
   environment situations where reads are far more common than writes.

 */
public class ConcurrentList {
    private static final Logger logger = LoggerFactory.getLogger(ConcurrentList.class);

    public static void main(String[] args) {
        logger.info("Java version: {}, Java vendor: {}", System.getProperty("java.version")
                , System.getProperty("java.vendor"));
        testCopyOnWriteArrayList();
    }

    private static void testCopyOnWriteArrayList() {
        List<Integer> list = new CopyOnWriteArrayList<>(Arrays.asList(4,3,52));
        for (
                Integer item : list) {
            System.out.print(item + " "); // 4, 3, 52
            list.add(9);
        }
        System.out.println();
        System.out.println("Size: " + list.size()); // 6
    }

}
