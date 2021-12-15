package org.ghy.multiThreadFrame.ch10.ch03_07.eg3;

public class Test2 {
    public static void main(String[] args) {

        try {
            MyserviceB myserviceB = new MyserviceB();
            ThreadB1 a  = new ThreadB1(myserviceB);
            a.setName("a");
            //放
            ThreadB2 b = new ThreadB2(myserviceB);
            b.setName("b");

            a.start();
            Thread.sleep(4000);
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
