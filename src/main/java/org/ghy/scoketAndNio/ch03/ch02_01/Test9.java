package org.ghy.scoketAndNio.ch03.ch02_01;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

//根据索引获得NetworkInterface对象
public class Test9 {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface>  networkInterface =  NetworkInterface.getNetworkInterfaces();
            while (networkInterface.hasMoreElements()){
                NetworkInterface eachNetworkInterface = networkInterface.nextElement();
                System.out.println("getName="+eachNetworkInterface.getName());
                System.out.println("getDisplayName="+eachNetworkInterface.getDisplayName());
                System.out.println("getIndex="+eachNetworkInterface.getIndex());
                System.out.println();
            }
            System.out.println();
            NetworkInterface newNetworkInterface = NetworkInterface.getByIndex(1);
            System.out.println("----->>>>"+newNetworkInterface.getName());
        } catch (SocketException e) {
            e.printStackTrace();
        }

    }
}
