package org.ghy.scoketAndNio.ch04.section01.ch01_07;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

//调用InputStream或OutputStream的close()方法造成Socket关闭.
//通过socket或得的Stream实际上是SocketInputStream/SocketOutputStream,稍微跟踪下源码就知道了
public class Server {
    public static void main(String[] args) {
        try {
            byte[] charArray = new byte[100];
            ServerSocket serverSocket = new ServerSocket(8088);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            int readLength = inputStream.read(charArray);
            while (readLength != -1){
                String newString = new String(charArray,0,readLength);
                System.out.println(newString+" "+System.currentTimeMillis());
                readLength = inputStream.read(charArray);
            }
            inputStream.close();
            //如果不注释掉就会出现异常
            OutputStream outputStream = socket.getOutputStream();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
