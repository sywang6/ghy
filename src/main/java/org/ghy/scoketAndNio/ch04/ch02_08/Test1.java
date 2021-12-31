package org.ghy.scoketAndNio.ch04.ch02_08;

import java.net.InetSocketAddress;

public class Test1 {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress1 = new InetSocketAddress("172.16.16.148",80);
        InetSocketAddress inetSocketAddress2 = new InetSocketAddress("172.16.16.148",80);
        //InetSocketAddresss对象是根据ip地址创建的,getHostName会触发根据ip地址查找域名,而getHostString则不会
        System.out.println(inetSocketAddress1.getHostName());
        System.out.println(inetSocketAddress2.getHostString());

        InetSocketAddress inetSocketAddress3 = new InetSocketAddress("172.16.16.148",80);
        InetSocketAddress inetSocketAddress4 = new InetSocketAddress("172.16.16.148",80);

        //对于同一个对象,先调用getHostName就会触发根据ip地址查找域名并设置hostname,在调用getHostString就能得得到hostname
        System.out.println(inetSocketAddress3.getHostName());
        System.out.println(inetSocketAddress3.getHostString());

        System.out.println(inetSocketAddress4.getHostString());
        System.out.println(inetSocketAddress4.getHostName());

    }
}
//shiyouwang.happyeasygo.com
//172.16.16.148
//shiyouwang.happyeasygo.com
//shiyouwang.happyeasygo.com
//172.16.16.148
//shiyouwang.happyeasygo.com