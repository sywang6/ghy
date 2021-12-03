package org.ghy.multiThreadCore.ch03.ch01_16;

/**
 * wait(5000);释放锁,过5秒钟会尝试获得锁,如果拿到锁了,就继续向下执行,时间没到或者没有竞争到锁,还是处于timed waiting状态
 */
public class Test {

    public static void main(String[] args) {
        MyService service = new MyService();
        MyThreadA[] array = new MyThreadA[10];
        for(int i=0;i<10;i++){
            array[i] = new MyThreadA(service);
        }
        for(int i=0;i<10;i++){
            array[i].start();
        }
        MyThreadB b = new MyThreadB(service);
        b.start();
    }

}
