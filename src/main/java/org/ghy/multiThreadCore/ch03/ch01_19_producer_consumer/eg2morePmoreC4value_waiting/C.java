package org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg2morePmoreC4value_waiting;

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
               /* if (ValueObject.value.equals("")) {
                    lock.wait();
                }*/

                //多生产者,多消费者,值为空,释放锁,等待生产者通知.与一生产者一消费者相比,这里判断
                //使用了while, 因为不确定唤醒wait的是生产者,还是另一消费者,所以唤醒之后还需进行再次判断
                while (ValueObject.value.equals("")) {
                    System.out.println("消费者 "+Thread.currentThread().getName()+" waiting了*");
                    lock.wait();
                }
                System.out.println("消费者 "+Thread.currentThread().getName()+" runnable了*");
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
