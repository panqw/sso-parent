package com.sso.proxy;


import java.lang.reflect.Proxy;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> {
            while (true){
                System.out.println("hahhhha");
                System.out.println(Thread.currentThread().getName());
            }
        });
    }
}
