package org.ghy.scoketAndNio.ch04.section03.ch03_11.eg5;





import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args) {
        try {
            StringBuffer buffer = new StringBuffer(1000000);
            for (int i = 0; i < 1000000; i++) {
                buffer.append("1");
            }
            buffer.append("end");
            System.out.println("Server填充完毕!");
            ServerSocket serverSocket = new ServerSocket(8888);
            Socket socket = serverSocket.accept();
            socket.setSendBufferSize(1000000);
            //on=true,linger=1,发送数据耗时大于1s,超过1s之后,不在发送数据给对端,并且发送RST标记
            socket.setSoLinger(true,1);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(buffer.toString().getBytes());
            long beginTime = 0;
            long endTime = 0;
            beginTime = System.currentTimeMillis();
            System.out.println("C="+beginTime);
            //实际测试时close阻塞1s,后对端会抛出connect reset异常
            socket.close();
            endTime = System.currentTimeMillis();
            System.out.println("D="+endTime);
            System.out.println("时间差:"+(endTime-beginTime));
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
