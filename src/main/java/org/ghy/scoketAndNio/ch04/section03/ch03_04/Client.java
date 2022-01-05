package org.ghy.scoketAndNio.ch04.section03.ch03_04;

import com.oracle.xmlns.internal.webservices.jaxws_databinding.SoapBindingParameterStyle;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8888);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
