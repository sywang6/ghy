package org.ghy.scoketAndNio.ch04.section03.ch03_06;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

//判断socket的状态
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket();
            System.out.println("1 socket.isBound()="+socket.isBound());
            socket.bind(new InetSocketAddress("localhost",7777));
            System.out.println("2 socket.isBound()="+socket.isBound());
            System.out.println("3 socket.isConnected()="+socket.isConnected());
            socket.connect(new InetSocketAddress("localhost",8888));
            System.out.println("4 socket.isConnected()="+socket.isConnected());
            System.out.println("5 socket.isClosed()="+socket.isClosed());
            socket.close();
            //关闭之后不能重新连接或者重新绑定,需要创建新的套接字(新建对象)
            //socket.bind(new InetSocketAddress("localhost",7778));
            System.out.println("6 socket.isClosed()"+socket.isClosed());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
