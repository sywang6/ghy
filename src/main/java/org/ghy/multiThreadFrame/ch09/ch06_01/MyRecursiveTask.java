package org.ghy.multiThreadFrame.ch09.ch06_01;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask extends RecursiveTask<String> {
    private static final long serialVersionUID = -2700082163509078786L;

    private int beginValue;
    private int endValue;

    public MyRecursiveTask(int beginValue, int endValue) {
        this.beginValue = beginValue;
        this.endValue = endValue;
    }

    @Override
    protected String compute() {
        System.out.println(Thread.currentThread().getName()+"----");
        if(endValue-beginValue>2){
            int middelValue = (endValue+beginValue)/2;
            MyRecursiveTask leftTask = new MyRecursiveTask(beginValue,middelValue);
            MyRecursiveTask rightTask = new MyRecursiveTask(middelValue+1,endValue);
            ForkJoinTask.invokeAll(leftTask,rightTask);
            return leftTask.join()+rightTask.join();
        }else{
            String returnString ="";
            for (int i = beginValue; i <=endValue ; i++) {
                returnString  = returnString+(i);
            }
            System.out.println("else 返回:"+returnString+" "+beginValue+" "+endValue);
            return returnString;
        }
    }
}
