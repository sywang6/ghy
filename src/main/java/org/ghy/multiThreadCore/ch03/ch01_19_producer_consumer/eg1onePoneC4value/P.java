package org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg1onePoneC4value;

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
                //值不空,释放锁,等待消费者消费
                if (!ValueObject.value.equals("")) {
                    lock.wait();
                }
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
