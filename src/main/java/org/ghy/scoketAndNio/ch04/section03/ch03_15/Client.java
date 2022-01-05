package org.ghy.scoketAndNio.ch04.section03.ch03_15;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket();
            //用于在IP头上设置流量类别
            //IPTOS_LOWCOST(0x02):发送成本低
            //IPTOS_RELIABILITY(0x04):高可靠性
            //IPTOS_THROUGHPUT(0x08):最高吞吐量
            //IPTOS_LOWDWLAT(0x10):最小延迟
            //4种类别可以使用"或"运算进行相应的组合
            socket.setTrafficClass(0x10);
            socket.connect(new InetSocketAddress("localhost",8888));
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("我是发送的数据!".getBytes());
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
