package org.ghy.scoketAndNio.ch05.ch08_08;

import java.io.IOException;
import java.net.Socket;

public class Test302 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",7777);
            socket.getOutputStream().write("12345".getBytes());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
