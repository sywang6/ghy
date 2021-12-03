package org.ghy.multiThreadFrame.ch04.ch03_12.discardoldestpolicy;

public class MyRunnable implements  Runnable{


    private String username;

    public MyRunnable(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    @Override
    public void run() {

        try {
            System.out.println(username+ " run ");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
