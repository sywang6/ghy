package org.ghy.scoketAndNio.ch05.ch08_06;

import java.io.IOException;
import java.net.Socket;

public class Test203 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8888);
            socket.close();

            Socket socket2 = new Socket("localhost",9999);
            socket2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
