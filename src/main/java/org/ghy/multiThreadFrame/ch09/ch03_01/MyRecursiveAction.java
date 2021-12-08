package org.ghy.multiThreadFrame.ch09.ch03_01;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class MyRecursiveAction extends RecursiveAction {

    private static final long serialVersionUID = -8310204761430135020L;
    private int beginValue;
    private int endValue;

    public MyRecursiveAction(int beginValue, int endValue) {
        this.beginValue = beginValue;
        this.endValue = endValue;
    }

    @Override
    protected void compute() {
        System.out.println(Thread.currentThread().getName()+"-----");
        if(endValue - beginValue >2){
            int middelNum = (beginValue+endValue)/2;
            MyRecursiveAction leftAction = new MyRecursiveAction(beginValue,middelNum);
            MyRecursiveAction rightAction = new MyRecursiveAction(middelNum+1,endValue);
            ForkJoinTask.invokeAll(leftAction,rightAction);
        }else{
            System.out.println(Thread.currentThread().getName()+"打印组合为:"+beginValue+"-"+endValue);
        }
    }
}
