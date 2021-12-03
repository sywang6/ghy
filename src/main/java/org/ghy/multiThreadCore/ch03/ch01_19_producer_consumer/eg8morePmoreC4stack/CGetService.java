package org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg8morePmoreC4stack;


public class CGetService {

    private Box box;

    public CGetService(Box box){
        this.box = box;
    }

    public void getMethod(){
        try{
            synchronized (this){
                while (box.size()==0){
                    System.out.println("ooooo");
                    this.wait();
                }
                box.popFirst();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

  public void checkBoxStatus(){
        try{
            while (true){
                synchronized (this){
                    if(box.size()>0){
                        this.notifyAll();
                    }
                }
                System.out.println("get checkboxBox = "+box.size());
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
  }

}
