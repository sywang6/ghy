package org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg2morePmoreC4value_waiting;

/**
 * 生产者
 */
public class P {

    private String lock;

    public P(String lock){
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
               /* if (!ValueObject.value.equals("")) {
                    lock.wait();
                }*/

                //多生产者,多消费者,值不空,释放锁,等待消费者消费.与一生产者一消费者相比,这里判断
                //使用了while, 因为不确定唤醒wait的是消费者,还是另一生产者,所以唤醒之后还需进行再次判断
                while (!ValueObject.value.equals("")) {
                    System.out.println("生产者 "+Thread.currentThread().getName()+" waiting了*");
                    lock.wait();
                }
                System.out.println("生产者 "+Thread.currentThread().getName()+" runnable了*");
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println("set的值是" + value);
                ValueObject.value = value;
                //值设置好了,通知消费者消费
                lock.notify();
            }

        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
