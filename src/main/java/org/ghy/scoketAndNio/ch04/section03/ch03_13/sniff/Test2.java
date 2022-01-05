package org.ghy.scoketAndNio.ch04.section03.ch03_13.sniff;

import java.io.IOException;
import java.net.Socket;

public class Test2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("172.16.16.148",8888);
        try {
            int count = 0;
            for(;;){
                //服务端是windows系统,17次之后,抛出 Connection reset by peer: send.
                //因为对端发送了RST
                socket.sendUrgentData(1);
                count++;
                System.out.println("执行了"+count+"次嗅探");
                Thread.sleep(10000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
