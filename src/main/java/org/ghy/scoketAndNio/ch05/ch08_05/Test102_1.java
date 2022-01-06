package org.ghy.scoketAndNio.ch05.ch08_05;

import java.io.IOException;
import java.net.Socket;

public class Test102_1 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",7777);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
