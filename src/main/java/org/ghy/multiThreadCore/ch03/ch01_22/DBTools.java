package org.ghy.multiThreadCore.ch03.ch01_22;

public class DBTools {

    volatile private boolean isBackupedA = false;

    synchronized  public void backupA(){
        try {
            //A备份过了,等待下一次备份
            while (isBackupedA) {
                wait();
            }
            System.out.println(Thread.currentThread().getName() + "备份A");
            isBackupedA = true;
            //通知备份B
            notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    synchronized public void backupB(){
        try {
            //B备份过了,等待下一次备份
            while (!isBackupedA) {
                wait();
            }
            System.out.println(Thread.currentThread().getName() + "备份B");
            isBackupedA = false;
            //通知备份A
            notifyAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
