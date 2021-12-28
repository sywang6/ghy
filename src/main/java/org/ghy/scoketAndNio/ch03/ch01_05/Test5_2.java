package org.ghy.scoketAndNio.ch03.ch01_05;

import java.net.InetAddress;
import java.net.UnknownHostException;

//根据主机名获得IP地址
public class Test5_2 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress myAddress = InetAddress.getByName("shiyouwang.happyeasygo.com");
        InetAddress baiduAddress = InetAddress.getByName("www.baidu.com");
        //172.19.240.1是本机局域网的地址
        InetAddress ipStringAddress = InetAddress.getByName("172.19.240.1");
        InetAddress localhostAddress = InetAddress.getByName("localhost");
        System.out.println(localhostAddress.getClass().getName()+" "+localhostAddress.getHostAddress());
        System.out.println(myAddress.getClass().getName()+" "+myAddress.getHostAddress());
        System.out.println(baiduAddress.getClass().getName()+" "+baiduAddress.getHostAddress());
        System.out.println(ipStringAddress.getClass().getName()+" "+ipStringAddress.getHostAddress());
        InetAddress notIpAddress = null;

        try {
            //不存在的ip地址,会出现异常
            notIpAddress = InetAddress.getByName("112.168.0.777");
            System.out.println(notIpAddress.getClass().getName()+" "+notIpAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        try {
            //不存在的域名,会出现异常
            InetAddress notDomainAddress = InetAddress.getByName("www.dddddd1234353534553535.com");
            System.out.println(notIpAddress.getClass().getName()+" "+notIpAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }
}
