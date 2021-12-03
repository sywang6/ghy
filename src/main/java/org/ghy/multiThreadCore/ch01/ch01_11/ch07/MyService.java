package org.ghy.multiThreadCore.ch01.ch01_11.ch07;

public class MyService {

    private String username = "a";
    private String password = "aa";

    synchronized public String getUsername(){
        return username;
    }
    synchronized public String getPassword(){
        return password;
    }

    synchronized public  void printString(String username,String password){

        try {
            this.username = username;
            Thread.sleep(10000000);
            this.password = password;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
