package org.ghy.scoketAndNio.ch03.ch01_04;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Test4 {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface>  networkInterface =  NetworkInterface.getNetworkInterfaces();
            while (networkInterface.hasMoreElements()){
                NetworkInterface eachNetworkInterface =   networkInterface.nextElement();
                System.out.println("getName获得网络设备名称="+eachNetworkInterface.getName());
                //获取物理地址
                System.out.println("getDisplayName获得网络设备显示名称="+eachNetworkInterface.getDisplayName());
                System.out.print("getHardwareAddress获得网口的物理地址=");
                byte[]  byteArray =  eachNetworkInterface.getHardwareAddress();
                if(byteArray != null && byteArray.length != 0){
                    for (int i = 0; i < byteArray.length; i++) {
                        String hex = Integer.toHexString(byteArray[i] & 0xFF);
                        if(hex.length() < 2){
                            System.out.print("0"+hex);
                        }else{
                            System.out.print(hex);
                        }
                        if(i!=byteArray.length-1){
                            System.out.print("-");
                        }
                    }

                }
                System.out.println();
                System.out.println();
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }


    }
}
