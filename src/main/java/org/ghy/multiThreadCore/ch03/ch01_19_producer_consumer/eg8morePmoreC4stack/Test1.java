package org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg8morePmoreC4stack;

/**
 * 多生产者多消费者,操作栈,wait条件发生改变,可能会出现IndexOutOfBoundsException异常
 */
public class Test1 {

    public static void main(String[] args) throws InterruptedException {
        Box box = new Box();
        PSetService pSetService = new PSetService(box);
        for (int i = 0; i < 2; i++) {
            SetValueThread setValueThread = new SetValueThread(pSetService);
            setValueThread.start();
        }
        //Thread.sleep(50);
        SetCheckThread setCheckThread = new SetCheckThread(pSetService);
        setCheckThread.start();

        //Thread.sleep(10000);
        CGetService cGetService = new CGetService(box);
        for (int i = 0; i < 10; i++) {
            GetValueThread getValueThread = new GetValueThread(cGetService);
            getValueThread.start();
        }
       // Thread.sleep(50);
        GetCheckThread getCheckThread = new GetCheckThread(cGetService);
        getCheckThread.start();

    }

}
