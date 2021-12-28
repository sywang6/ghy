package org.ghy.scoketAndNio.ch03.ch01_05;

import java.net.InetAddress;
import java.net.UnknownHostException;

//获得本地主机和回环地址的基本信息
public class Test5_1 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localhost = InetAddress.getLocalHost();
        System.out.print(" localhost.getAddress()地址为=");
        byte[] localIPAddress = localhost.getAddress();
        for (int i = 0; i < localIPAddress.length; i++) {
            System.out.print(" "+localIPAddress[i]+" ");
        }
        System.out.println();
        System.out.println(" "+localhost.getClass().getName());
        System.out.println();

        InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
        System.out.print(" localhost.getLoopbackAddress()地址为=");
        byte[] loopbackIPAddress = loopbackAddress.getAddress();
        for (int i = 0; i < loopbackIPAddress.length; i++) {
            System.out.print(" "+loopbackIPAddress[i]+" ");
        }
        System.out.println();
        System.out.println(" "+loopbackAddress.getClass().getName());

    }
}
