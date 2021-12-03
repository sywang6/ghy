package org.ghy.multiThreadCore.ch03.ch01_22;

public class Run {
    public static void main(String[] args) {
        DBTools dbTools = new DBTools();
       for (int i = 0; i < 10; i++) {
           Thread t =   new  Thread(){
                public void run(){
                    dbTools.backupB();
                }
            };
            t.setName("backupB"+i);
            t.start();
       }

        for (int i = 0; i < 10; i++) {
            Thread t =  new  Thread(){
                public void run(){
                    dbTools.backupA();
                }
            };
            t.setName("backupA"+i);
            t.start();
        }


    }


}
