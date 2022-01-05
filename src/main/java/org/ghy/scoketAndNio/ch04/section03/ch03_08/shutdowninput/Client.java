package org.ghy.scoketAndNio.ch04.section03.ch03_08.shutdowninput;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8088);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
