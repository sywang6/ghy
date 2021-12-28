package org.ghy.scoketAndNio.ch03.ch01_05;

import java.net.InetAddress;
import java.net.UnknownHostException;

//完全限定名与HostName,与DNS服务有直接的关系
public class Test5_6 {
    public static void main(String[] args) throws UnknownHostException {

        InetAddress address1 = InetAddress.getLocalHost();
        System.out.println("A1 "+address1.getCanonicalHostName());
        System.out.println("A2 "+address1.getHostName());
        System.out.println();

        InetAddress address2 = InetAddress.getByName("www.ibm.com");
        System.out.println("B1 "+address2.getCanonicalHostName());
        System.out.println("B2 "+address2.getHostName());
        System.out.println();

        InetAddress address3 = InetAddress.getByName("14.215.177.38");
        System.out.println("C1 "+address3.getCanonicalHostName());
        System.out.println("C2 "+address3.getHostName());
        System.out.println();

    }
}
//A1 shiyouwang.mshome.net
//A2 shiyouwang

//B1 a23-41-66-202.deploy.static.akamaitechnologies.com
//B2 www.ibm.com

//C1 14.215.177.38
//C2 14.215.177.38
