package org.ghy.scoketAndNio.ch04.ch01_01;

import java.io.IOException;
import java.net.Socket;

public class Test2 {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        try {
            //不存在的域名,则会出现异常
            socket = new Socket("www.csdnsfsfsfsfs.net",80);
            System.out.println("socket连接成功");
        } catch (IOException e) {
            System.out.println("socket连接失败");
            e.printStackTrace();
        }finally {
            socket.close();
        }
    }
}
