package org.ghy.scoketAndNio.ch03.ch01_05;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class Test5_5 {
    public static void main(String[] args) throws UnknownHostException {
        byte[] byteArray = new byte[]{-84, 16 ,16, -108};
        //根据主机名和IP地址byte[]addr获得InetAddress对象,并不对host的有效性进行验证,
        //参数host仅仅是参数addr的一个说明及备注,可以传任意值
        InetAddress myAddress = InetAddress.getByAddress("zzzzz",byteArray);
        System.out.println("myAddress.getHostAddress()="+myAddress.getHostAddress());
        System.out.println("myAddress.getHostName()="+myAddress.getHostName());
        System.out.println("myAddress.getClass().getName()="+myAddress.getClass().getName());

    }
}
//myAddress.getHostAddress()=172.16.16.148
//myAddress.getHostName()=shiyouwang.happyeasygo.com
//myAddress.getClass().getName()=java.net.Inet4Address