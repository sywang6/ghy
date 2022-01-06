package org.ghy.scoketAndNio.ch05.ch08_03;

import java.io.IOException;
import java.net.Socket;
import java.nio.channels.SocketChannel;

public class Test105 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",7777);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
