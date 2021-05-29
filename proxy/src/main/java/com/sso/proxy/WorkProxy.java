package com.sso.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class WorkProxy implements InvocationHandler {

    private Object work;

    public WorkProxy(Work work) {
        this.work = work;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("first===============================");

        Object invoke = method.invoke(work, args);

        System.out.println("last===============================");

        return invoke;
    }
}
