package org.ghy.multiThreadCore.ch03.ch01_18;

/**
 * while条件发生变化,总有一个subtract线程会出现异常
 */
public class Run {
    public static void main(String[] args) {
        String lock = new String("");

        Add add = new Add(lock);
        Subtract subtract = new Subtract(lock);

        ThreadSubtract subtract1Thread = new ThreadSubtract(subtract);
        subtract1Thread.setName("subtract1Thread");
        subtract1Thread.start();

        ThreadSubtract subtract2Thread = new ThreadSubtract(subtract);
        subtract2Thread.setName("subtract2Thread");
        subtract2Thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ThreadAdd addThread = new ThreadAdd(add);
        addThread.setName("addThread");
        addThread.start();

    }
}
