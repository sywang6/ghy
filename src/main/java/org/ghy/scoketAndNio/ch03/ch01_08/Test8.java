package org.ghy.scoketAndNio.ch03.ch01_08;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

//是否支持地址广播
public class Test8 {
    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> networkInterface =  NetworkInterface.getNetworkInterfaces();
        while (networkInterface.hasMoreElements()){
            NetworkInterface eachNetworkInterface = networkInterface.nextElement();
            System.out.println("getName获得网络设备名称="+eachNetworkInterface.getName());
            System.out.println("getDisplayName获得网络设备显示名称="+eachNetworkInterface.getDisplayName());
            System.out.println("supportsMulticast是否支持地址广播="+eachNetworkInterface.supportsMulticast());
            System.out.println();
            System.out.println();
        }
    }
}
