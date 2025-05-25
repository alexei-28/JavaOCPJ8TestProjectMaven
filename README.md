# JavaTestProjectMaven
Java test project build by Maven


Java-тестирование приватных методов:

https://habr.com/ru/companies/otus/articles/888298/

The @VisibleForTesting annotation is used to indicate that a program element (like a method or field) 
has a visibility that is wider than strictly necessary for production code, specifically to make it accessible for testing.

Here's a breakdown of what it implies:

- Intent Communication: It clearly signals to other developers that the increased visibility is a deliberate choice to aid testing, acknowledging a potential compromise in encapsulation.
- Static Analysis: Tools can inspect this annotation to identify instances where these elements are being used outside of test code, which might be undesirable.
- Direct Testing: It allows tests to directly access and manipulate elements that would otherwise be less accessible (e.g., private or package-private), simplifying testing in some scenarios, especially for legacy code.
- No Runtime Enforcement: The annotation itself doesn't prevent production code from accessing the annotated element. It's more of a convention and a hint for developers and static analysis tools.

Different libraries and frameworks provide their own versions of this annotation, including:

- Guava: com.google.common.annotations.VisibleForTesting
- Android: androidx.annotation.VisibleForTesting or android.support.annotation.VisibleForTesting
- JetBrains (IntelliJ): org.jetbrains.annotations.VisibleForTesting
- AssertJ: org.assertj.core.util.VisibleForTesting
- Apache Flink: org.apache.flink.annotation.VisibleForTesting
- JUnit (dp4j): While not the standard JUnit annotation, dp4j provides a similar functionality.
- Flutter (Dart): package:meta/meta.dart includes @visibleForTesting.

In essence, @VisibleForTesting serves as a developer aid to balance good encapsulation practices with the need for effective unit testing. 
While it doesn't enforce visibility restrictions at runtime, it's a valuable tool for communicating intent and can be leveraged by static analysis tools to maintain code quality.