package org.ghy.scoketAndNio.ch04.section03.ch03_11.eg4;





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
            //on=true,linger=10,发送数据耗时小于10s,发送端缓冲区的数据全部发送到对端
            //进行正常的4次挥手
            socket.setSoLinger(true,10);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(buffer.toString().getBytes());
            long beginTime = 0;
            long endTime = 0;
            beginTime = System.currentTimeMillis();
            System.out.println("C="+beginTime);
            //实际测试时close方法会阻塞一段时间
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
