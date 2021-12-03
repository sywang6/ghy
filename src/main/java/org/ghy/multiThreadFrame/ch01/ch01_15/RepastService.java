package org.ghy.multiThreadFrame.ch01.ch01_15;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class RepastService {

    volatile private Semaphore setSemaphore = new Semaphore(10);
    volatile private Semaphore getSemaphore = new Semaphore(10);
    volatile  private ReentrantLock lock = new ReentrantLock();
    volatile private Condition setCondition = lock.newCondition();
    volatile private Condition getSetCondition = lock.newCondition();
    volatile private Object[] producePosition = new Object[4];

    private boolean isEmpty(){
        boolean isEmpty = true;
        for (int i = 0; i < producePosition.length; i++) {
            if(producePosition[i] != null){
                isEmpty = false;
                break;
            }
        }
        return  isEmpty;
    }


    private boolean isFull(){
        boolean isFull = true;
        for (int i = 0; i < producePosition.length; i++) {
            if(producePosition[i] == null){
                isFull = false;
                break;
            }
        }
        return  isFull;
    }

    public  void set(){
        try {
            setSemaphore.acquire();
            lock.lock();
            while (isFull()){
                setCondition.await();
            }
            for (int i = 0; i < producePosition.length; i++) {
                if(producePosition[i] == null){
                    producePosition[i] = "数据";
                    System.out.println(Thread.currentThread().getName()+"生产了"+producePosition[i]);
                    break;
                }
            }
            getSetCondition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            setSemaphore.release();
        }
    }

    public void get(){
        try {
            getSemaphore.acquire();
            lock.lock();
            while (isEmpty()){
                getSetCondition.await();
            }
            for (int i = 0; i < producePosition.length; i++) {
                if(producePosition[i] != null){
                    System.out.println(Thread.currentThread().getName()+"消费了"+producePosition[i]);
                    producePosition[i] = null;
                    break;
                }
            }
            setCondition.signalAll();
            lock.unlock();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            getSemaphore.release();
        }

    }


}
