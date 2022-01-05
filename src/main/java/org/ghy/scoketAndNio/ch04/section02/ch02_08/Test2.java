package org.ghy.scoketAndNio.ch04.section02.ch02_08;

import java.net.InetAddress;
import java.net.InetSocketAddress;

public class Test2 {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("localhost",8080);
        //从InetSocketAddress对象获取InetAddress对象
        InetAddress inetAddress = inetSocketAddress.getAddress();
        byte[] ipAddress = inetAddress.getAddress();
        for (int i = 0; i < ipAddress.length; i++) {
            System.out.print((byte)ipAddress[i]+" ");
        }
    }
}
