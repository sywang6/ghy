package org.ghy.multiThreadCore.ch02.ch03_01.eg5;

public class Service {
    String anyString  = new String();
    private boolean isContinueRun = true;

    public void runMethod(){
        while (isContinueRun){
            synchronized (anyString){

            }
        }
        System.out.println("停下来了!");
    }

    public  void stopMethod(){
        isContinueRun = false;
    }
}
