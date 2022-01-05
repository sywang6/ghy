package org.ghy.scoketAndNio.ch04.section02.ch02_12.serverPortReuse;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

//服务端端口不允许复用
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        Thread server = new Thread(){
            @Override
            public void run() {
                try {
                    ServerSocket serverSocket = new ServerSocket();
                    //是否允许端口复用.Test1的main方法允许之后,8888端口处于TIME_WAIT状态,如果不允许复用,在次运行Test1
                    //是绑定不到8888端口的.如果允许复用,则可以绑定到处于TIME_WAIT状态的端口(需要在Linux环境下运行)
                    serverSocket.setReuseAddress(false);
                    serverSocket.bind(new InetSocketAddress("172.16.16.148",8888));
                    Socket socket = serverSocket.accept();
                    Thread.sleep(1000);
                    socket.close();//服务端先主动关闭连接
                    serverSocket.close();//服务端先主动关闭连接
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        server.start();
        Thread.sleep(500);
        Thread  client = new Thread(){
          public void run(){
              try {
                  Socket socket = new Socket("172.16.16.148",8888);
                  Thread.sleep(3000);
                  socket.close();
              } catch (IOException e) {
                  e.printStackTrace();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        };
        client.start();

    }
}
