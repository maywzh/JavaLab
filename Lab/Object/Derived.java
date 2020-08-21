
import java.lang.reflect.*;

class Log {
    public static String baseFieldInit() {
        System.out.println("Base Normal Field");
        return "";
    }

    public static String baseStaticFieldInit() {
        System.out.println("Base Static Field");
        return "";
    }

    public static int baseFinalFieldInit() {
        System.out.println("Base Final Field");
        return 0;
    }

    public static String fieldInit() {
        System.out.println("Normal Field");
        return "";
    }

    public static String staticFieldInit() {
        System.out.println("Static Field");
        return "";
    }

    public static int finalFieldInit() {
        System.out.println("Final Field");
        return 1;
    }
}

class Base {
    static {
        System.out.println("Base Static Block 1");
    }
    private static String staticValue = Log.baseStaticFieldInit();
    private final int finalValue = Log.baseFinalFieldInit();
    static {
        System.out.println("Base Static Block 2");
    }

    {
        System.out.println("Base Normal Block 1");
    }

    private String value = Log.baseFieldInit();

    {
        System.out.println("Base Normal Block 2");
    }

    Base() {
        System.out.println("Base Constructor");
    }
}

/**
 * Derived
 */
public class Derived extends Base {
    static {
        System.out.println("Static Block 1");
    }
    private static String staticValue = Log.staticFieldInit();
    private final int finalValue = Log.finalFieldInit();

    static {
        System.out.println("Static Block 2");
    }

    {
        System.out.println("Normal Block 1");
    }

    private String value = Log.fieldInit();
    {
        System.out.println("Normal Block 2");
    }

    Derived() {
        System.out.println("Derived Constructor");
    }

    public static void main(String[] args) {
        new Derived();
        System.out.println();
        new Derived();
    }
}