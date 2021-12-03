package org.ghy.multiThreadCore.ch02.ch03_01.eg4;

public class Run {
    public static void main(String[] args) {
        try{
            RunThread thread = new RunThread();
            thread.start();
            Thread.sleep(1000);
            thread.setRunning(false);
            System.out.println("已赋值为false");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
