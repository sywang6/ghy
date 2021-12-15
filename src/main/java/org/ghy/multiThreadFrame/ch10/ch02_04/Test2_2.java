package org.ghy.multiThreadFrame.ch10.ch02_04;

public class Test2_2 {
    public static void main(String[] args) {
        MyService1 service1 = new MyService1();
        service1.queue.add("a");
        service1.queue.add("b");
        service1.queue.add("c");
        System.out.println(service1.queue.poll());
    }
}
