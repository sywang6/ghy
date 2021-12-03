package org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg8morePmoreC4stack;

public class PSetService {
 private Box box;
 public PSetService(Box box){
     this.box = box;
 }

 public  void setMethmod(){
    try {
        synchronized (this) {
            while (box.size() == 50) {
                System.out.println(".....");
                this.wait();
            }
        }
        Thread.sleep(300);
        box.add();
    }catch (Exception e){
        e.printStackTrace();
    }
 }


 public void checkBoxStatus(){
     try {
         while (true) {
             synchronized (this) {
                 if (box.size() < 50) {
                     this.notifyAll();
                 }
             }
             System.out.println("set checkboxBox = " + box.size());
             Thread.sleep(1000);
         }
     }catch (InterruptedException e){
         e.printStackTrace();
     }
 }


}
