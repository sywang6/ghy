package org.ghy.multiThreadFrame.ch09.ch10_01;

import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<Integer> {
    private static final long serialVersionUID = -1152981382098510371L;

    @Override
    protected Integer compute() {


            try {
                Thread.sleep(1000);
                Integer.parseInt("a");
            } catch (NumberFormatException  e) {
                e.printStackTrace();
                throw  e;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        return 100;
    }
}
