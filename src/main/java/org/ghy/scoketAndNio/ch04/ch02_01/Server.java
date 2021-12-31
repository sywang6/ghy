package org.ghy.scoketAndNio.ch04.ch02_01;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
             serverSocket = new ServerSocket(8000);
            System.out.println(serverSocket.getSoTimeout());
            serverSocket.setSoTimeout(10000);
            System.out.println(serverSocket.getSoTimeout());
            System.out.println("begin "+System.currentTimeMillis());
            //阻塞4秒钟后,还没有连接连上来,将抛出SocketTimeoutException异常.
            //但serverSocket仍能继续接受连接
            serverSocket.accept();
            System.out.println("end "+System.currentTimeMillis());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            serverSocket.accept();
            System.out.println("go on");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
