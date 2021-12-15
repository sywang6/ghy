package org.ghy.multiThreadFrame.ch10.ch03_07.eg2;

public class Test2 {
    public static void main(String[] args) {
        try {
            MyserviceB myserviceB = new MyserviceB();
            ThreadB2 threadB2 = new ThreadB2(myserviceB);
            threadB2.setName("b");
            threadB2.start();

            ThreadB2 threadB3 = new ThreadB2(myserviceB);
            threadB3.setName("b1");
            threadB3.start();

            Thread.sleep(3000);
            System.out.println("队列中的元素个数为: "+myserviceB.queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
