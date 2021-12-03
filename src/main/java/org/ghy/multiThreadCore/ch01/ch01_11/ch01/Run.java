package org.ghy.multiThreadCore.ch01.ch01_11.ch01;

public class Run {

    public static void main(String[] args) throws InterruptedException {
        MyThread thread = new MyThread();
        thread.start();
        Thread.sleep(2000);
        //向thread线程发送了一个中断信号,但是thread线程并没有立即相应这个中断信息继续输出i=xxx,java采用的是响应式中断
        thread.interrupt();
        System.out.println("zzzzzzzzzzzz");
    }
}
