package org.ghy.scoketAndNio.ch04.section03.ch03_14;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            System.out.println("client begin");
            Socket socket = new Socket("localhost",8888);
            System.out.println("a="+socket.getKeepAlive());
            //若对方在某个时间(时间取决于操作系统内核的设置)内没有发送任何数据过来,那么端点会发送一个ACK探测包到对方
            //实际开发使用得不多,更多的是使用一个线程来轮询嗅探
            socket.setKeepAlive(true);
            System.out.println("b="+socket.getKeepAlive());
            System.out.println("client end");
            Thread.sleep(Integer.MAX_VALUE);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
