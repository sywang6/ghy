package org.ghy.scoketAndNio.ch04.ch02_06;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 5000; i++) {
            System.out.println("client begin "+(i+1));
            Socket socket = new Socket("localhost",8888);
            System.out.println("client end "+(i+1));
        }
    }
}
