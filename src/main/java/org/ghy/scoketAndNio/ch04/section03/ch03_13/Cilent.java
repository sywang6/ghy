package org.ghy.scoketAndNio.ch04.section03.ch03_13;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Cilent {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8888);
            OutputStream outputStream = socket.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            //紧急数据包立即发送
            socket.sendUrgentData(97);

            outputStreamWriter.write("zzzzzzzzzzzzzzzzzzzzzzzz!");
            socket.sendUrgentData(98);
            socket.sendUrgentData(99);
            //刷新发送缓冲区,将常规数据包发送给对端
            outputStreamWriter.flush();
            socket.sendUrgentData(100);
            outputStreamWriter.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
