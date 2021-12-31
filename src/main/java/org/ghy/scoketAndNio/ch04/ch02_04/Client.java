package org.ghy.scoketAndNio.ch04.ch02_04;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            System.out.println(inetAddress.getHostName()+" "+inetAddress.getHostAddress());

            for (int i = 0; i < 100; i++) {
                //Socket socket = new Socket("localhost",8088); //在使用localhost已经连不上服务端啦
                Socket socket = new Socket(inetAddress,8088);
                System.out.println("client发起连接次数:"+(i+1));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
