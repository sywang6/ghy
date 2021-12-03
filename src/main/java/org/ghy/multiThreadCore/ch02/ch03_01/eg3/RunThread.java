package org.ghy.multiThreadCore.ch02.ch03_01.eg3;

public class RunThread extends  Thread{

    private boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void run(){
        System.out.println("进入run了");
        while (isRunning == true){

        }
        System.out.println("线程被停止了");
    }
}
