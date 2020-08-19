package com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import net.sf.cglib.proxy.Enhancer;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // UserService userService = new UserServiceImpl();
        // InvocationHandler invocationHandler = new MyInvocationHandler(userService);
        // UserService userServiceProxy = (UserService)
        // Proxy.newProxyInstance(userService.getClass().getClassLoader(),
        // userService.getClass().getInterfaces(), invocationHandler);
        // System.out.println(userServiceProxy.getName(1));
        // System.out.println(userServiceProxy.getAge(1));
        CglibProxyImpl cglibProxy = new CglibProxyImpl();

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(cglibProxy);

        UserService o = (UserService) enhancer.create();
        o.getName(1);
        o.getAge(1);
    }
}
