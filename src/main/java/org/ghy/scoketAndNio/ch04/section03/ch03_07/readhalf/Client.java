package org.ghy.scoketAndNio.ch04.section03.ch03_07.readhalf;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8088);
            OutputStream out = socket.getOutputStream();
            out.write("abcdefg".getBytes());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
