package org.ghy.scoketAndNio.ch04.ch02_03;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            //测试backlog的默认值是50s
            ServerSocket serverSocket = new ServerSocket(8088);
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
