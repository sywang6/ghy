package org.ghy.multiThreadCore.ch01.ch01_11.ch07;

public class Run {

    public static void main(String[] args) {
        try {
            MyService myService = new MyService();
            MyThreadA myThreadA = new MyThreadA(myService);
            MyThreadB myThreadB = new MyThreadB(myService);
            //启动线程A,获得myService锁,设置了用户名,进入sleep,锁并未释放
            myThreadA.start();
            Thread.sleep(1000);
            //启动线程B,获取用户名/密码获得myService锁
            myThreadB.start();
            Thread.sleep(2000);
            //暴力停止线程A,线程A会释放myService锁, 但是设置密码并未执行,线程B获得锁,打印信息为username:b password:aa,
            //是不是有点错乱了
            myThreadA.stop();
       /*     Thread.sleep(2000);
            System.out.println("线程A的状态:"+myThreadA.getState());
            myThreadA.start()*/;
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
