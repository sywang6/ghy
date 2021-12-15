package org.ghy.multiThreadFrame.ch10.ch02_04;

public class Test2_1 {
    public static void main(String[] args) {
        MyService1 service1 = new MyService1();
        System.out.println(service1.queue.poll());
    }
}
