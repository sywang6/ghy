package org.ghy.scoketAndNio.ch04.ch01_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CreateWebServer {
    public static void main(String[] args) throws IOException {
        //原作者使用的是6666端口,谷歌浏览器认为一些端口不安全比如6666~6669,默认封了一下端口,所有这里我换了一个端口
        ServerSocket serverSocket = new ServerSocket(7777);
        Socket socket = serverSocket.accept();
        InputStream inputStream =  socket.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String getString ="";
       while (!"".equals(getString = bufferedReader.readLine())){
            System.out.println(getString);
        }
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
        outputStream.write(("<html><body><a href='https://www.baidu.com'>i " +
                "am baidu,com welcome you!</a></body></html>").getBytes());
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        socket.close();
        serverSocket.close();



    }
}





















