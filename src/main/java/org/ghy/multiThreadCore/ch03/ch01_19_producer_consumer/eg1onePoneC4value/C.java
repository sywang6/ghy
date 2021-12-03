package org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg1onePoneC4value;

/**
 * 消费者
 */
public class C {

    private String lock;

    public C(String lock){
        this.lock = lock;
    }

    public void getValue(){
        try {
            synchronized (lock) {
                //值为空,释放锁,等待生产者通知
                if (ValueObject.value.equals("")) {
                    lock.wait();
                }
                System.out.println("get的值是" + ValueObject.value);
                ValueObject.value = "";
                //消费完了,通知生产者快生产
                lock.notify();

            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
