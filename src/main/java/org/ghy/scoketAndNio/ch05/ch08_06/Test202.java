package org.ghy.scoketAndNio.ch05.ch08_06;

import java.io.IOException;
import java.net.Socket;

public class Test202 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",7777);
            Thread.sleep(20000);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
