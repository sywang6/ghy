package org.ghy.multiThreadCore.ch03.ch01_04;

public class Test1 {
    public static void main(String[] args) {
        try{
            String newString = new String("");
            newString.wait();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
