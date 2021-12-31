package org.ghy.scoketAndNio.ch04.ch01_14;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            //创建ObjectOutputStream时候会发送一个magic数
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            //创建ObjectInputStream间接调用readShort()方法,我们知道read方法阻塞的,所以客户端和服务端不能都先初始化objectInputStream
            //,否则会导致阻塞,都在等着对方发送数据.客户端和服务端均先初始化ObjectOutputStream,或者初始化顺序相反都是可以的
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            for (int i = 0; i < 5; i++) {
                //读取一个对象
                UserInfo userInfo = (UserInfo)objectInputStream.readObject();
                System.out.println("在服务端打印"+(i+1)+":"+userInfo.getId()+" "+userInfo.getUsername()+" "+userInfo.getPassword());

                UserInfo newUserinfo = new UserInfo();
                newUserinfo.setId(i+1);
                newUserinfo.setUsername("serverUsername"+(i+1));
                newUserinfo.setPassword("serverPassword"+(i+1));
                //向对方发送一个对象
                objectOutputStream.writeObject(newUserinfo);

            }
            objectOutputStream.close();
            objectInputStream.close();

            outputStream.close();
            inputStream.close();

            socket.close();
            serverSocket.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}











