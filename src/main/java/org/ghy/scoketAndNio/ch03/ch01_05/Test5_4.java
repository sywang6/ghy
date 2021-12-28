package org.ghy.scoketAndNio.ch03.ch01_05;

import java.net.InetAddress;
import java.net.UnknownHostException;

//根据IP地址byte[] addr获得InetAddress对象
public class Test5_4 {
    public static void main(String[] args) throws UnknownHostException {
        byte[] byteArray = new byte[]{-84, 16 ,16, -108};
        InetAddress myAddress = InetAddress.getByAddress(byteArray);
        System.out.println("myAddress.getHostAddress()="+myAddress.getHostAddress());
        System.out.println("myAddress.getHostName()="+myAddress.getHostName());
        System.out.println("myAddress.getClass().getName()="+myAddress.getClass().getName());

    }
}
//myAddress.getHostAddress()=172.16.16.148
//myAddress.getHostName()=shiyouwang.happyeasygo.com
//myAddress.getClass().getName()=java.net.Inet4Address