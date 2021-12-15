package org.ghy.multiThreadFrame.ch10.ch03_06;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Userinfo  implements Delayed {

    private long delayNanoTime;
    private String username;

    public Userinfo(long delayNanoTime, String username) {
        this.delayNanoTime = delayNanoTime;
        this.username = username;
    }

    public long getDelayNanoTime() {
        return delayNanoTime;
    }

    public String getUsername() {
        return username;
    }



    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(delayNanoTime-System.nanoTime(),TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {

        if((this.getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS) )< 0 ){
            return  -1;
        }
        if((this.getDelay(TimeUnit.NANOSECONDS) - o.getDelay(TimeUnit.NANOSECONDS) )> 0 ){
            return  1;
        }
        return 0;
    }
}
