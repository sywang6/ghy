package org.ghy.scoketAndNio.ch04.ch02_08;

import java.net.InetSocketAddress;

public class Test3 {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress1 = new InetSocketAddress("www.baidu.com",80);
        System.out.println(inetSocketAddress1.isUnresolved());

        InetSocketAddress inetSocketAddress2 = new InetSocketAddress("www.baidu323ee242424.com",80);
        System.out.println(inetSocketAddress2.isUnresolved());

        //创建InetSocketAddress时不解析hostname,ServerSocket是不能绑定到一个未解析的InetSocketAddress上的
        InetSocketAddress inetSocketAddress3 = InetSocketAddress.createUnresolved("www.baidu.com",80);
        System.out.println(inetSocketAddress3.isUnresolved());

        InetSocketAddress inetSocketAddress4 = InetSocketAddress.createUnresolved("www.baidukfdkkdf.com",80);
        System.out.println(inetSocketAddress4.isUnresolved());


    }
}
