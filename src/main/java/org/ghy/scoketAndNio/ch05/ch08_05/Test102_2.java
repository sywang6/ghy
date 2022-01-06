package org.ghy.scoketAndNio.ch05.ch08_05;

import java.io.IOException;
import java.net.Socket;

public class Test102_2 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8888);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
