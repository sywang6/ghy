package org.ghy.scoketAndNio.ch03.ch01_06;

import java.net.InetAddress;
import java.net.InterfaceAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.List;

public class Test6 {
    public static void main(String[] args) throws SocketException {
        //获得网络设置
        Enumeration<NetworkInterface>  networkInterface =  NetworkInterface.getNetworkInterfaces();
        while (networkInterface.hasMoreElements()){
            NetworkInterface eachNetworkInterface = networkInterface.nextElement();
            System.out.println("getName获得网络设备的名称="+eachNetworkInterface.getName());
            System.out.println("getDisplayName获得网络设备显示名称="+eachNetworkInterface.getDisplayName());
            //接口地址
            List<InterfaceAddress> interfaceAddressList =   eachNetworkInterface.getInterfaceAddresses();
            for (int i = 0; i < interfaceAddressList.size(); i++) {
                InterfaceAddress interfaceAddress = interfaceAddressList.get(i);
                //从接口地址获得一个网络地址
                InetAddress inetAddress = interfaceAddress.getAddress();
                if (inetAddress!=null){
                    System.out.println("    interfaceAddress.getAddress()="+inetAddress.getHostName());
                }
                //从接口地址获得广播地址
                InetAddress inetAddressBroadcast = interfaceAddress.getBroadcast();
                if (inetAddressBroadcast!=null){
                    System.out.println("    interfaceAddress.getBroadcast()="+inetAddressBroadcast.getHostName());
                }
                System.out.println("    getNetworkPrefixLength="+interfaceAddress.getNetworkPrefixLength());
                System.out.println();
            }
            System.out.println();
        }

    }
}
