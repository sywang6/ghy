package org.ghy.scoketAndNio.ch03.ch02_03;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

//通过InetAddress对象获得NetworkInterface对象
public class Test11 {
    public static void main(String[] args) {

        try {
            //如果指定的ip地址绑定到多个网络接口,则不确定返回哪个网络接口.
            //在Linux中,bonding的含义是将多个物理的网卡抽象成一块网卡
            InetAddress localhostAddress = InetAddress.getByName("127.0.0.1");
            NetworkInterface  networkInterface =  NetworkInterface.getByInetAddress(localhostAddress);
            System.out.println(networkInterface.getName());
            System.out.println(networkInterface.getDisplayName());
        } catch (UnknownHostException | SocketException e) {
            e.printStackTrace();
        }


    }
}
