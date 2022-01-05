package org.ghy.scoketAndNio.ch04.section02.ch02_04;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            //只接受指定地址的连接,如果bindAddr为null,则默认接受任何/所有本地地址上的连接
            ServerSocket serverSocket = new ServerSocket(8088,50,inetAddress);
            Thread.sleep(50000);
            for (int i = 0; i < 100; i++) {
                System.out.println("accept1 begin"+(i+1));
                Socket socket = serverSocket.accept();
                System.out.println("accept1 end"+(i+1));
            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
