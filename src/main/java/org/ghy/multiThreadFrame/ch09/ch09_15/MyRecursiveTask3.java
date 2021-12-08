package org.ghy.multiThreadFrame.ch09.ch09_15;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class MyRecursiveTask3 extends RecursiveTask<Integer> {
    private static final long serialVersionUID = -2125287510381984207L;
    private int beginPosition;
    private int endPosition;

    public MyRecursiveTask3(int beginPosition, int endPosition) {
        this.beginPosition = beginPosition;
        this.endPosition = endPosition;
    }

    @Override
    protected Integer compute() {
        Integer sumValue = 0;
        if((endPosition-beginPosition)>2){
            int middleNum = (endPosition+beginPosition)/2;
            MyRecursiveTask3 leftTask = new MyRecursiveTask3(beginPosition,middleNum);
            MyRecursiveTask3 rightTask = new MyRecursiveTask3(middleNum+1,endPosition);
            ForkJoinTask.invokeAll(leftTask,rightTask);
            Integer leftValue = leftTask.join();
            Integer rightValue = rightTask.join();
            return leftValue+rightValue;
        }else{
            int count = 0;
            for (int i = beginPosition; i <=endPosition ; i++) {
                count = count+i;
            }
            return count;
        }

    }
}
