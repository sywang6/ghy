package org.ghy.scoketAndNio.ch03.ch01_07;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

//是不是点对点设备
public class Test7 {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> networkInterface =  NetworkInterface.getNetworkInterfaces();
        while (networkInterface.hasMoreElements()){
            NetworkInterface eachNetworkInterface = networkInterface.nextElement();
            System.out.println("getName获得网络设备名称="+eachNetworkInterface.getName());
            System.out.println("getDisplayName获得网络设备显示名称="+eachNetworkInterface.getDisplayName());
            System.out.println("isPointToPoint是不是点对点设备="+eachNetworkInterface.isPointToPoint());
            System.out.println();
            System.out.println();
        }
    }
}
