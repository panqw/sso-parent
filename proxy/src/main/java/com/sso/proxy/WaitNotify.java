package com.sso.proxy;

public class WaitNotify {

    private Integer flag;

    private Integer loopNumber;

    public WaitNotify(Integer flag, Integer loopNumber) {
        this.flag = flag;
        this.loopNumber = loopNumber;
    }

    public void print(String str,Integer waitFlag,Integer nextFlag){
        synchronized (this){
            while (waitFlag!=flag){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println(str);
            this.notifyAll();
            flag=nextFlag;
        }
    }
}
