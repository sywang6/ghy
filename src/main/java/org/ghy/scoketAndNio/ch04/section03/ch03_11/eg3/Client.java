package org.ghy.scoketAndNio.ch04.section03.ch03_11.eg3;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket();
            //设置超小的缓存区,方便观察从对端传递过来的数据
            socket.setReceiveBufferSize(1);
            socket.bind(new InetSocketAddress("localhost",7077));
            socket.connect(new InetSocketAddress("localhost",8088));
            InputStream inputStream = socket.getInputStream();
            byte[] byteArray = new byte[1];
            int readLength = inputStream.read(byteArray);
            while (readLength!=-1){
                System.out.println(new String(byteArray,0,readLength));
                readLength = inputStream.read(byteArray);
            }
            System.out.println("client read end time="+System.currentTimeMillis());
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
