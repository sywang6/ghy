package org.ghy.multiThreadCore.ch03.ch01_19_producer_consumer.eg4onePoneC4stack;

public class C {

    private MyStack myStack;
    public C(MyStack myStack){
        this.myStack = myStack;
    }
    public void popService(){
        System.out.println("pop="+myStack.pop());
    }

}
