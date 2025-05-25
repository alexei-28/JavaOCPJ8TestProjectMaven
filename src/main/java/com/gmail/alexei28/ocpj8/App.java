package com.gmail.alexei28.ocpj8;
import com.gmail.alexei28.ocpj8.anonymous.Animal;
import com.gmail.alexei28.ocpj8.anonymous.ClientListener;
import com.gmail.alexei28.ocpj8.anonymous.ClientStatus;
import com.gmail.alexei28.ocpj8.anonymous.MyInterfaceAnonymous;
import com.gmail.alexei28.ocpj8.anonymous.MyIoClient;
import com.gmail.alexei28.ocpj8.anonymous.StatusListener;
import com.gmail.alexei28.ocpj8.myabstractclass.AbstractCar;
import com.gmail.alexei28.ocpj8.myinterface.MyInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Application's entry point
 * Run by mvn:
 *   mvn compile exec:java -Dexec.mainClass="com.gmail.alexei28.ocpj8.App"
 */

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        logger.info("Java version: {}, Java vendor: {}", System.getProperty("java.version")
                , System.getProperty("java.vendor"));

        Animal animal = new Animal();
        animal.makeNoise();

        Animal bigFoot = new Animal() {
            //Anonymous Inner Class
            @Override
            public void makeNoise() {
                logger.debug("Big foot make noise");
            }
        };
        // Call method of anonymous inner class
        bigFoot.makeNoise();

        MyInterfaceAnonymous myInterfaceAnonymous = new MyInterfaceAnonymous() {
            @Override
            public void myInnerMethod(String arg) {
                logger.debug("MyInterface_ arg = {}" , arg);
            }
        };

        ClientListener clientListener = new ClientListener() {
            @Override
            public void addClientStatusListener(StatusListener statusListener) {
                logger.debug("addClientStatusListener, statusListener = {}",statusListener);
                statusListener.statusChange(ClientStatus.AUTHORIZED);
            }
        };
        new MyIoClient(clientListener);
        myInterfaceAnonymous.myInnerMethod("some string");

        createAnonymousInstanceOfAbstractClass();
        createAnonymousInstanceOfInterface();
    }

    public static void createAnonymousInstanceOfAbstractClass() {
        //AbstractCar abstractCar = new AbstractCar(); // Compile error - 'AbstractCar' is abstract; cannot be instantiated
        AbstractCar abstractCar = new AbstractCar() {

            @Override
            public int someAbstractMethod() {
                return 130;
            }
        };

        logger.info("result in abstract class = {}", abstractCar.getResult());
        logger.info("someAbstractMethod in abstract class = {}", abstractCar.someAbstractMethod());
    }

    public static void createAnonymousInstanceOfInterface() {
        //MyInterface myInterface = new MyInterface(); // 'MyInterface' is abstract; cannot be instantiate

        MyInterface myInterfaceAnonymous = new MyInterface() {

        };
    }
}

