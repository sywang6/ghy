package org.ghy.scoketAndNio.ch03.ch01_05;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test5_3 {
    public static void main(String[] args) throws UnknownHostException {
        //根据主机名获得所有的IP地址
        InetAddress[] myAddressArray = InetAddress.getAllByName("shiyouwang");
        InetAddress[] baiduAddressArray = InetAddress.getAllByName("www.baidu.com");
        InetAddress[] ipStringAddressArray = InetAddress.getAllByName("172.16.16.148");
        for (int i = 0; i < myAddressArray.length; i++) {
            InetAddress myAddress = myAddressArray[i];
            System.out.println("myAddress.getHostAddress()="+myAddress.getHostAddress()+" "+myAddress.getClass().getName());
        }
        System.out.println();
        for (int i = 0; i < baiduAddressArray.length; i++) {
            InetAddress baiduAddress = baiduAddressArray[i];
            System.out.println("baiduAddress.getHostAddress()="+baiduAddress.getHostAddress()+" "+baiduAddress.getClass().getName());
        }
        System.out.println();
        for (int i = 0; i < ipStringAddressArray.length; i++) {
            InetAddress ipStringAddress = ipStringAddressArray[i];
            System.out.println("ipStringAddress.getHostAddress()="+ipStringAddress.getHostAddress()+" "+ipStringAddress.getClass().getName());
        }

    }
}
