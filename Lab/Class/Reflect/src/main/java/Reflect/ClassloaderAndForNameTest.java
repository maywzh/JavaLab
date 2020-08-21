package com.maywzh.Reflect;

class Line {
    static {
        System.out.println("静态代码块执行：loading line");
    }

}

class Point {
    static {
        System.out.println("静态代码块执行：loading point");
    }

}

public class ClassloaderAndForNameTest {
    public static void main(String[] args) {
        String wholeNameLine = "com.maywzh.Reflect.Line";
        String wholeNamePoint = "com.maywzh.Reflect.Point";
        System.out.println("下面是测试Classloader的效果");
        testClassloader(wholeNameLine, wholeNamePoint);
        System.out.println("----------------------------------");
        System.out.println("下面是测试Class.forName的效果");
        testForName(wholeNameLine, wholeNamePoint);
    }

    private static void testClassloader(String wholeNameLine, String wholeNamePoint) {
        Class<?> line;
        Class<?> point;
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        try {
            line = loader.loadClass(wholeNameLine);
            point = loader.loadClass(wholeNamePoint);
            System.out.println("line   " + line.getName());
            System.out.println("point   " + point.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void testForName(String wholeNameLine, String wholeNamePoint) {
        try {
            Class line = Class.forName(wholeNameLine);
            Class point = Class.forName(wholeNamePoint);
            System.out.println("line   " + line.getName());
            System.out.println("point   " + point.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}