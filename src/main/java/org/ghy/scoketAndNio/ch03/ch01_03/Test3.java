package org.ghy.scoketAndNio.ch03.ch01_03;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

//Linux系统有子网口的概念,windows没有.本实验需要在linux系统下运行
public class Test3 {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface>  networkInterface =  NetworkInterface.getNetworkInterfaces();
            while (networkInterface.hasMoreElements()){
                NetworkInterface eachNetworkInterface =   networkInterface.nextElement();
                System.out.println("eachNetworkInterface的hashCode="+eachNetworkInterface.hashCode());
                System.out.println("getName获得网络设备名称="+eachNetworkInterface.getName());
                System.out.println("getDisplayName获得网络设备显示名称="+eachNetworkInterface.getDisplayName());
                System.out.println("isVirtual是否为虚拟接口="+eachNetworkInterface.isVirtual());
                System.out.println("getParent获得父接口="+(eachNetworkInterface.getParent()==null?"null":eachNetworkInterface.getParent().hashCode()));
                System.out.println("getSubInterfaces获得子接口=");
                Enumeration<NetworkInterface>  networkInterfaceSub =  eachNetworkInterface.getSubInterfaces();
                while (networkInterfaceSub.hasMoreElements()){
                    NetworkInterface eachNetworkInterfaceSub = networkInterfaceSub.nextElement();
                    System.out.println("    getName获得网络设备名称="+eachNetworkInterfaceSub.getName());
                    System.out.println("    getDisplayName获得网络设备显示名称="+eachNetworkInterfaceSub.getDisplayName());
                    System.out.println("    isVirtual是否为虚拟接口="+eachNetworkInterfaceSub.isVirtual());
                    System.out.println("    getParent获得父接口="+(eachNetworkInterfaceSub.getParent()==null?"null":eachNetworkInterfaceSub.getParent().hashCode()));
                }
                System.out.println();
                System.out.println();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }


    }
}
