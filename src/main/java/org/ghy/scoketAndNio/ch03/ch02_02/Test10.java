package org.ghy.scoketAndNio.ch03.ch02_02;

import java.net.NetworkInterface;
import java.net.SocketException;

//根据网络接口名称获得NetworkInterface对象
public class Test10 {
    public static void main(String[] args) {
        try{
            NetworkInterface networkInterface = NetworkInterface.getByName("lo");
            System.out.println("----->>>>"+networkInterface.getName());
        }catch (SocketException e){
            e.printStackTrace();
        }
    }
}
