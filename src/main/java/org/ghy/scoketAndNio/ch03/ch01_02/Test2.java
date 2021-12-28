package org.ghy.scoketAndNio.ch03.ch01_02;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Test2 {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface>  networkInterface =  NetworkInterface.getNetworkInterfaces();
            while (networkInterface.hasMoreElements()){
                NetworkInterface eachNetworkInterface =   networkInterface.nextElement();
                System.out.println("getName获得网络设备名称="+eachNetworkInterface.getName());
                System.out.println("getDisplayName获得网络设备显示名称="+eachNetworkInterface.getDisplayName());
                //获取MTU
                System.out.println("getMtu获得最大传输单元="+eachNetworkInterface.getMTU());
                System.out.println();
                System.out.println();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }


    }
}
